package pl.skleprowerowy.projekt;

import org.springframework.beans.factory.annotation.Autowired;
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
        return "index.html";
    }

    @GetMapping("/loadData")
    public String loadData() {
        Bike bike = new Bike();
        bike.setProductName("Rower XMA");
        bike.setPrice(1244);
        bike.setBikeType("MTB");
        bike.setColor("Zielony");
        bikeRepository.save(bike);
        Bike bike2 = new Bike();
        bike2.setProductName("Rower AA");
        bike2.setPrice(320.99);
        bike2.setBikeType("MTB");
        bike2.setColor("Czerwony");
        bikeRepository.save(bike2);
        Bike bike3 = new Bike();
        bike3.setProductName("Rower KAAAS");
        bike3.setPrice(133.99);
        bike3.setBikeType("MTB");
        bike3.setColor("Czarna");
        bikeRepository.save(bike3);

        return "index.html";
    }



}
