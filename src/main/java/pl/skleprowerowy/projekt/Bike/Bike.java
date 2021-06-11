package pl.skleprowerowy.projekt.Bike;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skleprowerowy.projekt.Opinion.Opinion;
import pl.skleprowerowy.projekt.Product.Product;
import pl.skleprowerowy.projekt.Repair.Repair;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("bike")
public class Bike extends Product {
    @NotNull
    private String bikeType;

    @NotNull
    private String Color;

    @OneToMany(mappedBy = "bike")
    @JsonManagedReference
    private Set<Repair> repairs = new HashSet<Repair>();

}
