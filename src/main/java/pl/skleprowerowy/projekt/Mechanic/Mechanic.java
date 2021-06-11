package pl.skleprowerowy.projekt.Mechanic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skleprowerowy.projekt.Person.Person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("mechanic")
public class Mechanic extends Person {

}
