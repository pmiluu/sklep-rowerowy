package pl.skleprowerowy.projekt.Person;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skleprowerowy.projekt.Adress.Adress;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Adress adress;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String phoneNumber;

    @NotNull
    private LocalDate birthDate;

    private PersonType personType = PersonType.Person;

    private String password;

    private String email;

    @Column(nullable = true)
    private Integer discount;

    private String personalId;

    @Column(nullable = true)
    private Double salary;

    private int getAge(){
        int age = Period.between(birthDate,LocalDate.now()).getYears();
        return age;
    }



}
