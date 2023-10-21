package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Truck implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "truck_Id_generator")
    @SequenceGenerator(name = "truck_Id_generator", sequenceName = "truck_sequence", initialValue = 100, allocationSize = 1)
    private Long truckId;
    private String model;
    private int year;
    private boolean availability;

    private String licensePlate;
    private double currentMileage;
    private int brandId;
}
