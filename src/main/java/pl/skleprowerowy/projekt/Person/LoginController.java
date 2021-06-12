package pl.skleprowerowy.projekt.Person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String showLoginForm(){
        return "login";
    }

    @PostMapping
    public String loginForm(){
        return "redirect:/shop/";
    }
}
