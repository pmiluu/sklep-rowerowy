package pl.skleprowerowy.projekt.Orders;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope("session")
public class ProductInfo {
    private int productId;
    private String productName;
    private int quantity;
}
