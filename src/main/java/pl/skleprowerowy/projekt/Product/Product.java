package pl.skleprowerowy.projekt.Product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skleprowerowy.projekt.ProductOrder.ProductOrder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private Set<ProductOrder> productOrders = new HashSet<ProductOrder>();

    @NotNull
    private String productName;

    @NotNull
    private double price;

    @NotNull
    private static double vatRate = 1.23;

}
