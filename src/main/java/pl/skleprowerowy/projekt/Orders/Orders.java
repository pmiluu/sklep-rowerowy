package pl.skleprowerowy.projekt.Orders;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skleprowerowy.projekt.Person.Person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "person_id")

    @JsonBackReference
    private Person person;

    @NotNull
    private LocalDate orderDate;

    private OrderStatus orderStatus = OrderStatus.NEW;

    //todo
    public double getOrderPrice(){
        return 0;
    }





}
