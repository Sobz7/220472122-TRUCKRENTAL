// Rental Factory Class
// Author: Sobantu Malotana (220472122)
// Date: 07 April 2023

package za.ac.cput.factory;


import za.ac.cput.domain.Rental;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class RentalFactory {

    public static Rental createRental(int rentalId, int customerId, int truckId, LocalDate startDate, LocalDate endDate, double rentalCost) {

        if(Helper.isNullorEmpty(String.valueOf(startDate)) || Helper.isNullorEmpty(String.valueOf(endDate)))
            return null;

        Rental.Builder builder = new Rental.Builder();
        builder.setRentalId(rentalId);
        builder.setCustomerId(customerId);
        builder.setTruckId(truckId);
        builder.setStartDate(LocalDate.parse(startDate.toString()));
        builder.setEndDate(LocalDate.parse(endDate.toString()));
        builder.setRentalCost(rentalCost);
        return builder
                .build();
    }

}