// Rental Factory Class
// Author: Sobantu Malotana (220472122)
// Date: 07 April 2023

package za.ac.cput.factory;

import za.ac.cput.domain.Rental;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
public class RentalFactory {

    public static Rental createRental(int rentalId, int customerId, int truckId, String startDate, String endDate, double rentalCost) {

        if(Helper.isNullorEmpty(String.valueOf(startDate)) || Helper.isNullorEmpty(String.valueOf(endDate)))
            return null;

        return new Rental.Builder().setRentalId(rentalId)
                .setCustomerId(customerId)
                .setTruckId(truckId)
                .setStartDate(LocalDate.parse(startDate))
                .setEndDate(LocalDate.parse(endDate))
                .setRentalCost(rentalCost)
                .build();
    }
}

