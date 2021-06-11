package pl.skleprowerowy.projekt.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping(path = "/persons")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewPerson(@RequestParam String firstName, @RequestParam String lastName,
                                             @RequestParam String birthDate, @RequestParam String phoneNumber){
        Person p = new Person();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setBirthDate(LocalDate.of(2002,1,1));
        p.setPhoneNumber(phoneNumber);
        personRepository.save(p);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Person> getAllPersons(){
        return personRepository.findAll();
    }
}
