package pl.skleprowerowy.projekt.Person;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skleprowerowy.projekt.Adress.Adress;
import pl.skleprowerowy.projekt.Orders.Orders;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    @JsonManagedReference
    private Adress adress;

    @OneToMany(mappedBy = "person")
    @JsonManagedReference
    private Set<Orders> orders = new HashSet<Orders>();

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

    public int getAge(){
        int age = Period.between(birthDate,LocalDate.now()).getYears();
        return age;
    }



}
