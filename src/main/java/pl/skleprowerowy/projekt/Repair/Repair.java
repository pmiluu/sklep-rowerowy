package pl.skleprowerowy.projekt.Repair;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skleprowerowy.projekt.Bike.Bike;
import pl.skleprowerowy.projekt.Mechanic.Mechanic;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "mechanic_id")
    @JsonBackReference
    private Mechanic mechanic;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "bike_id")
    @JsonBackReference
    private Bike bike;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private double cost;

    private RepairStatus status = RepairStatus.NEW;

}
