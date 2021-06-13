package pl.skleprowerowy.projekt.Orders;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import pl.skleprowerowy.projekt.Person.Person;
import pl.skleprowerowy.projekt.Person.PersonRepository;
import pl.skleprowerowy.projekt.Product.Product;
import pl.skleprowerowy.projekt.Product.ProductRepository;
import pl.skleprowerowy.projekt.ProductOrder.ProductOrder;
import pl.skleprowerowy.projekt.ProductOrder.ProductOrderRepository;
import pl.skleprowerowy.projekt.Seller.Seller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping(path = "/shop")
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductOrderRepository productOrderRepository;

    @GetMapping("/")
    public String productsList(Model model) {
        model.addAttribute("quantity",1);
        model.addAttribute("products",productRepository.findAll());
        return "products";
    }


    @PostMapping("/")
    public String basket(@ModelAttribute("productInfo") ProductInfo productInfo, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<ProductInfo> basket = (List<ProductInfo>) request.getSession().getAttribute("BASKET");
        if(basket ==null){
            basket = new ArrayList<>();
            request.getSession().setAttribute("BASKET", basket);
        }

        boolean flag = basket.stream().anyMatch(productInfo1 -> productInfo1.getProductId().equals(productInfo.getProductId()));

        if(flag){
            Optional<ProductInfo> p = basket.stream().filter(productInfo1 -> productInfo1.getProductId().equals(productInfo.getProductId())).findAny();
            p.get().setQuantity(p.get().getQuantity()+productInfo.getQuantity());
        }else{
            basket.add(productInfo);
        }



        request.getSession().setAttribute("BASKET", basket);
        return "redirect:/shop/basket/";
    }

    @GetMapping("basket/")
    public String basket(HttpSession session, Model model) {
        List<ProductInfo> basket = (List<ProductInfo>) session.getAttribute("BASKET");

        if(basket == null){
            basket = new ArrayList<>();
        }

        model.addAttribute("products",basket);
        return "basket";
    }

    @PostMapping("basket/")
    public String basketDelete(@ModelAttribute("productInfo") ProductInfo productInfo, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<ProductInfo> basket = (List<ProductInfo>) request.getSession().getAttribute("BASKET");
        if(basket ==null){
            basket = new ArrayList<>();
            request.getSession().setAttribute("BASKET", basket);
        }
        Optional<ProductInfo> p = basket.stream().filter(productInfo1 -> productInfo1.getProductId().equals(productInfo.getProductId())).findAny();
        basket.remove(p.get());
        request.getSession().setAttribute("BASKET", basket);
        return "redirect:/shop/basket/";
    }

    @PostMapping("basket/order")
    public String basketOrder(@ModelAttribute("deliveryInfo") ProductInfo productInfo, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<ProductInfo> basket = (List<ProductInfo>) request.getSession().getAttribute("BASKET");
        Set<ProductOrder> basketSet = new HashSet<>();
        String name = request.getUserPrincipal().getName();
        Person person = personRepository.findByUsername(name);
        List<ProductOrder> productOrderList = new ArrayList<>();
        for (ProductInfo p: basket) {
            ProductOrder productOrder = new ProductOrder();
            Product product = productRepository.findById(p.getProductId()).get();
            productOrder.setProduct(product);
            productOrder.setQuantity(p.getQuantity());
            basketSet.add(productOrder);

            productOrderList.add(productOrder);
        }
        Orders order = new Orders();
        order.setPerson(person);
        order.setOrderDate(LocalDate.now());
        order.setProductOrders(basketSet);

        orderRepository.save(order);

        for (ProductOrder p:productOrderList) {
            p.setOrders(order);
        }
        productOrderRepository.saveAll(productOrderList);





        return "redirect:/shop/basket/";
    }



    @PostMapping("/destroy")
    public String destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }

}
