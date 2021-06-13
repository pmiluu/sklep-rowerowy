package pl.skleprowerowy.projekt.Person;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.skleprowerowy.projekt.Adress.Adress;
import pl.skleprowerowy.projekt.Orders.Orders;
import pl.skleprowerowy.projekt.Rental.Rental;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "employeeType", discriminatorType = DiscriminatorType.STRING)
public class Person implements UserDetails {
    public Person(String username){
        this.username = username;
    }

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

    @OneToMany(mappedBy = "person")
    @JsonManagedReference
    private Set<Rental> rentals = new HashSet<Rental>();

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String phoneNumber;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private PersonType personType = PersonType.Person;

    private String email;

    @Column(nullable = true)
    private Integer discount;

    private String personalId;

    @Column(nullable = true)
    private Double salary;

    public int getAge() {
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        return age;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
