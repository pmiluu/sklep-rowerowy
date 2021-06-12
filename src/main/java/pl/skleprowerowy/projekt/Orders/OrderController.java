package pl.skleprowerowy.projekt.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import pl.skleprowerowy.projekt.Product.Product;
import pl.skleprowerowy.projekt.Product.ProductRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/shop")
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String productsList(Model model) {
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

    @PostMapping("/destroy")
    public String destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }

}
