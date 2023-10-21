package za.ac.cput.domain;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "truck_Id_generator")
    @SequenceGenerator(name = "truck_Id_generator", sequenceName = "truck_sequence", initialValue = 100, allocationSize = 1)
    private Long id;
    private String description;
    private int truckSize;
    private String truckType;

}
