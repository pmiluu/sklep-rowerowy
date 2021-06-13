package pl.skleprowerowy.projekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.skleprowerowy.projekt.Bike.Bike;
import pl.skleprowerowy.projekt.Bike.BikeRepository;


@Controller
public class HomeController {
    @Autowired
    BikeRepository bikeRepository;
    @GetMapping("/")
    public String index() {

        Bike bike = new Bike();
        bike.setProductName("Rower XMA");
        bike.setPrice(1244);
        bike.setBikeType("MTB");
        bike.setColor("Zielony");
        bikeRepository.save(bike);

        return "index.html";
    }
}
