// Rental Repository Class.java
// Author: Sobantu Malotana (220472122)
// Date: 07 April 2023

package za.ac.cput.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Rental;
import za.ac.cput.repository.IRentalRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Repository
public abstract class RentalRepository implements IRentalRepository {
    public static RentalRepository repository = null;

    private Set<Rental> rentalDB = null;

    public RentalRepository() {
        rentalDB = new HashSet<Rental>();
    }


    public static RentalRepository getRepository() {
        if (repository == null) {
            repository = new RentalRepository() {
                @Override
                public Optional<Rental> findById(Integer rentalId) {
                    return Optional.empty();
                }

                @Override
                public Rental read(String s) {
                    return null;
                }

                @Override
                public boolean delete(String s) {
                    return false;
                }


                public boolean delete() {
                    return false;
                }
            };
        }
        return repository;
    }
    @Override
    public Rental create(Rental rental) {
        boolean success = rentalDB.add(rental);
        if (!success)
            return null;
        return rental;
    }

    @Override
    public Rental read(int rentalId) {
        for (Rental e : rentalDB) {
            int eRentalId = (int) e.getRentalId();
            {
                return e;
            }
        }
        return null;
    }

    @Override
    public Rental update(Rental rental) {
        Rental oldRental = read((Integer) rental.getRentalId());
        if (oldRental != null) {
            rentalDB.remove(oldRental);
            rentalDB.add(rental);
            return rental;
        }
        return null;
    }

    @Override
    public boolean delete(int rentalId) {
        Rental rentalToDelete = read(rentalId);
        if (rentalToDelete == null)
            return false;
        rentalDB.remove(rentalToDelete);
        return true;
    }
    @Override
    public Set<Rental> getAll() {
        return rentalDB;
    }

    public abstract Optional<Rental> findById(Integer rentalId);

    public boolean existsById(Integer rentalId){
     return true;
    }
}

