package pl.skleprowerowy.projekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.skleprowerowy.projekt.Bike.Bike;
import pl.skleprowerowy.projekt.Bike.BikeRepository;

@SpringBootApplication
public class ProjektApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ProjektApplication.class, args);

	}


}
