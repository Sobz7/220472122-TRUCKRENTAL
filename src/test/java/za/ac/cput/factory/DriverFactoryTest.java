/*
DriverFactoryTest.java
1st Factory Test Class
@Author: Siyakha Manisi (219239657)
09 April 2023
* */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Driver;

import static org.junit.jupiter.api.Assertions.*;

class DriverFactoryTest {

    @Test
    public void test()
    {
        Driver driver = new Driver.Builder().setDriverID("5652D")
                .setName("Apollo")
                .setSurname("Crews")
                .setEmail("apollo@gmail.com")
                .setIdNumber(760203)
                .setLicenseNo("760203AC")
                .setTelephone(123456)
                .setRentalID(0)
                .build();
        System.out.println(driver.toString());
        assertNotNull(driver);
    }

}