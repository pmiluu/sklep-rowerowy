package pl.skleprowerowy.projekt.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping("/profil")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/")
    public String profilDetails(Authentication authentication, Model model) {
        Person person = personRepository.findByUsername(authentication.getName());
        model.addAttribute("person",person);
        return "profil";
    }
}
