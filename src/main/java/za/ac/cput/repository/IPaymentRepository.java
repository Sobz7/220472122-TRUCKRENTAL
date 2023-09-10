// IPayment Repository Class.java
// Author: Sobantu Malotana (220472122)
// Date: 07 April 2023

package za.ac.cput.repository;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Payment;

import java.util.Set;
@Repository
public interface IPaymentRepository extends IRepository<Payment, String> {

    Payment read(int paymentId);

    default boolean delete(int paymentId) {
        return false;
    }
    public Set<Payment> getAll();
}
