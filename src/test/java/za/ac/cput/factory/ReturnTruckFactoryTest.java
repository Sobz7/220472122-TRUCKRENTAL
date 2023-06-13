//Return Truck Factory test Class
//Author: Chenique Jacobs (220388172)
//Date: 08/04/2023
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.ReturnTruck;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReturnTruckFactoryTest {
    @Test
    public void test(){
        ReturnTruck returnTruck = ReturnTruckFactory.createReturnTruck(01,01,00.00, LocalDate.parse("2023-04-03"));
        assertNotNull(returnTruck);
        System.out.println(returnTruck);
    }

}