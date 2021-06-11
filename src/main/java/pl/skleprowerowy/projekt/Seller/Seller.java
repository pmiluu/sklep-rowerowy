package pl.skleprowerowy.projekt.Seller;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skleprowerowy.projekt.Orders.Orders;
import pl.skleprowerowy.projekt.Person.Person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("seller")
public class Seller extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private int bonus;

    @OneToMany(mappedBy = "seller")
    @JsonManagedReference
    private Set<Orders> orders = new HashSet<Orders>();

}
