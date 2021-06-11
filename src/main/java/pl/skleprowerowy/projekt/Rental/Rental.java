package pl.skleprowerowy.projekt.Rental;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skleprowerowy.projekt.Bike.Bike;
import pl.skleprowerowy.projekt.Person.Person;
import pl.skleprowerowy.projekt.Product.Product;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "bike_id")
    @JsonBackReference
    private Bike bike;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonBackReference
    private Person person;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;


}
