package pl.skleprowerowy.projekt;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.skleprowerowy.projekt.Adress.Adress;
import pl.skleprowerowy.projekt.Bike.Bike;
import pl.skleprowerowy.projekt.Bike.BikeRepository;
import pl.skleprowerowy.projekt.Orders.OrderRepository;
import pl.skleprowerowy.projekt.Orders.OrderStatus;
import pl.skleprowerowy.projekt.Orders.Orders;
import pl.skleprowerowy.projekt.Person.Person;
import pl.skleprowerowy.projekt.Person.PersonRepository;
import pl.skleprowerowy.projekt.Seller.Seller;
import pl.skleprowerowy.projekt.Seller.SellerRepository;

import java.time.LocalDate;

@Controller
@RequestMapping(path = "/persons")
public class TestController {
    @Autowired
    private BikeRepository bikeRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewPerson(@RequestParam String firstName, @RequestParam String lastName,
                                             @RequestParam String birthDate, @RequestParam String phoneNumber){
        Bike bike = new Bike();
        bike.setProductName("Rower XMA");
        bike.setPrice(1244);
        bike.setBikeType("MTB");
        bike.setColor("Zielony");
        bikeRepository.save(bike);


        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Bike> getAllPersons(){
        return bikeRepository.findAll();
    }
}
