package pl.skleprowerowy.projekt.Orders;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope("session")
public class DeliveryInfo {
    private String zipCode;
    private String street;
    private int houseNumber;
    private int apartmentNumber;
    private String City;
}

