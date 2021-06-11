package pl.skleprowerowy.projekt.Mechanic;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skleprowerowy.projekt.Person.Person;
import pl.skleprowerowy.projekt.Repair.Repair;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("mechanic")
public class Mechanic extends Person {
    @OneToMany(mappedBy = "mechanic")
    @JsonManagedReference
    private Set<Repair> repairs = new HashSet<Repair>();

}
