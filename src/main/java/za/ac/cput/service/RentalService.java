// Rental Service Class.java
// Author: Sobantu Malotana (220472122)
// Date: 07 June 2023

package za.ac.cput.service;

import za.ac.cput.domain.Rental;

import java.util.Set;
public interface RentalService extends IService<Rental, String> {
    Rental create(Rental rental);

    Rental read(String rentalID);

    Rental update(Rental rental);

    boolean delete(int rentalID);

    Set<Rental> getAll();
}
