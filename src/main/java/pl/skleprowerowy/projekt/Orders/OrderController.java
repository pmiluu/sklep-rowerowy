package pl.skleprowerowy.projekt.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.skleprowerowy.projekt.Product.ProductRepository;

@Controller
@RequestMapping(path = "/shop")
public class OrderController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String productsList(Model model) {
        model.addAttribute("products",productRepository.findAll());
        return "products";
    }

   

}
