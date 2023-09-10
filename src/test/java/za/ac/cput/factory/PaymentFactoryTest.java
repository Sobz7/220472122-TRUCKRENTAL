// PaymentFactory Test.java
// Payment Factory Test Classes
// Author: Sobantu Malotana (220472122)
// Date: 07 April 2023
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {
    @Test
    public void test(){
        Payment payment = PaymentFactory.createPayment(123,"EFT",750, LocalDate.parse("2023-04-04"));
        System.out.println(payment.toString());
        assertNotNull(payment);
    }

}