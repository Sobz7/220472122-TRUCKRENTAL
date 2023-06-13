/*
DriverFactory.java
1st Factory Class
@Author: Siyakha Manisi (219239657)
09 April 2023
* */

package za.ac.cput.factory;

import za.ac.cput.domain.Driver;
import za.ac.cput.util.Helper;

public class DriverFactory {
    public static Driver createDriver(String name, String surname , String email , int idNumber, String licenseNo, int telephone, int rentalID)
    {
        if (Helper.isNullorEmpty(name) || Helper.isNullorEmpty(surname)
                || Helper.isNullorEmpty(licenseNo)
                || Helper.isNullorEmpty(String.valueOf(idNumber))
                || Helper.isNullorEmpty(String.valueOf(telephone))
                || Helper.isNullorEmpty(String.valueOf(rentalID))
            ) {
            return null;
        }


        String driverID = Helper.generateId();

        if(!Helper.isValidEmail(email))
        {

            return null;
        }

        Driver driver = new Driver.Builder().setDriverID(driverID)
                .setName(name)
                .setSurname(surname)
                .setEmail(email)
                .setIdNumber(idNumber)
                .setLicenseNo(licenseNo)
                .setTelephone(telephone)
                .setRentalID(rentalID)
                .build();

        return driver;
    }
}
