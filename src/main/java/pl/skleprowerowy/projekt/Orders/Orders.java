package pl.skleprowerowy.projekt.Orders;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skleprowerowy.projekt.Person.Person;
import pl.skleprowerowy.projekt.ProductOrder.ProductOrder;
import pl.skleprowerowy.projekt.Seller.Seller;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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


    @ManyToOne
    @JoinColumn(name = "seller_id")
    @JsonBackReference
    private Seller seller;

    @OneToMany(mappedBy = "orders")
    @JsonManagedReference
    private Set<ProductOrder> productOrders = new HashSet<ProductOrder>();

    @NotNull
    private LocalDate orderDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.NEW;

    public double getOrderPrice(){
        double sum = 0;
        for (ProductOrder p: productOrders) {
            sum += p.getProduct().getPrice()*p.getQuantity();
        }
        return sum;
    }





}
