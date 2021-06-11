package pl.skleprowerowy.projekt.Person;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skleprowerowy.projekt.Adress.Adress;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;
import java.util.EnumSet;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String phoneNumber;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private Adress adress;

    private EnumSet<PersonType> types = EnumSet.of(PersonType.Person);

    private String password;

    private String email;

    private int discount;

    private String personalId;

    private double salary;

    private int getAge(){
        int age = Period.between(birthDate,LocalDate.now()).getYears();
        return age;
    }



}
