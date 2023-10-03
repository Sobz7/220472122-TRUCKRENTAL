package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {

//    List<Customer> findAll();
    //Customer findByCustomerId(String customerId);
//    Customer findEmail( String email);
//    Optional<Customer> findOneByEmailAndPassword (String Email, String Password );

    Optional<Customer> findByCustomerId(String customerId);

}
