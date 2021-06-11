package pl.skleprowerowy.projekt.Person;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.skleprowerowy.projekt.Adress.Adress;
import pl.skleprowerowy.projekt.Orders.OrderRepository;
import pl.skleprowerowy.projekt.Orders.OrderStatus;
import pl.skleprowerowy.projekt.Orders.Orders;

import java.time.LocalDate;

@Controller
@RequestMapping(path = "/persons")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewPerson(@RequestParam String firstName, @RequestParam String lastName,
                                             @RequestParam String birthDate, @RequestParam String phoneNumber){
        Person p = new Person();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setBirthDate(LocalDate.of(2002,1,1));
        p.setPhoneNumber(phoneNumber);

        Adress a = new Adress();
        a.setCity("Wroclaw");
        a.setApartmentNumber(12);
        a.setHouseNumber(5);
        a.setStreet("Kwiatowa");
        a.setZipCode("11-121");

        p.setAdress(a);
        personRepository.save(p);


        Orders o = new Orders();
        o.setOrderDate(LocalDate.now());
        o.setOrderStatus(OrderStatus.SENT);
        o.setPerson(p);
        orderRepository.save(o);




        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Person> getAllPersons(){
        return personRepository.findAll();
    }
}
