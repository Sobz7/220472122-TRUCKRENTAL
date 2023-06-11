package za.ac.cput.service;

import za.ac.cput.domain.Rental;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface RentalService extends IService<Rental, String> {
    Rental create(Rental rental);

    Rental read(String rentalID);

    Rental update(Rental rental);

    boolean delete(int rentalID);

    Set<Rental> getAll();
}
