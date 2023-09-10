package za.ac.cput.domain;
/*Brand Entity
Author Ayanda Phumzile Khoza
Student Number 218057172
 */

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
