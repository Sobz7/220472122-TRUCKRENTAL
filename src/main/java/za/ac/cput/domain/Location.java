package za.ac.cput.domain;
/*Location Entity
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
public class Location {

    private int locationId;

    private String locationName;

    private String address;

}
