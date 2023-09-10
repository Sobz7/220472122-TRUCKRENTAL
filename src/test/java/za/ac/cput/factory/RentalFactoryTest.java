// RentalFactory Test.java
// Rental Factory Test Classes
// Author: Sobantu Malotana (220472122)
// Date: 07 April 2023

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Rental;

import static org.junit.jupiter.api.Assertions.*;

class RentalFactoryTest {
    @Test
    public void test(){
        Rental rental = RentalFactory.createRental(122,12,123,"2023-04-04","2023-05-30",42750.0);
        System.out.println(rental.toString());
        assertNotNull(rental);
    }
}