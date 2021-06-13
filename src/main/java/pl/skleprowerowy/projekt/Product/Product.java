package pl.skleprowerowy.projekt.Product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skleprowerowy.projekt.Opinion.Opinion;
import pl.skleprowerowy.projekt.ProductOrder.ProductOrder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "productType", discriminatorType = DiscriminatorType.STRING)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private Set<ProductOrder> productOrders = new HashSet<ProductOrder>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference
    private Set<Opinion> opinions = new HashSet<Opinion>();

    @NotNull
    private String productName;

    @NotNull
    private double price;

    @NotNull
    private static double vatRate = 1.23;

    public void addOpinion(String opinion){
        Opinion o = new Opinion();
        o.setOpinion(opinion);
        o.setProduct(this);
        o.setOpinionDate(LocalDate.now());
        opinions.add(o);
    }

}
