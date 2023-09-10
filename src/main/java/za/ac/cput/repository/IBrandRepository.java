package za.ac.cput.repository;
/*Author Ayanda Phumzile Khoza
Student Number 218057172
 */

import za.ac.cput.domain.Brand;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<Brand, String>
{
    List<Brand> findAll();
}
