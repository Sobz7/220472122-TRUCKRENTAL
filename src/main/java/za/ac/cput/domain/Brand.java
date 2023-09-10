package za.ac.cput.domain;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Brand {

    private int brandId;

    private String brandName;

    private String model;

    private String color;

    private String locationId;
}