package pl.skleprowerowy.projekt.Adress;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skleprowerowy.projekt.Person.Person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "adress")
    @JsonBackReference
    private Person person;

    @NotNull
    private String zipCode;

    @NotNull
    private String street;

    @NotNull
    private int houseNumber;

    @NotNull
    private int apartmentNumber;

    @NotNull
    private String City;

}


