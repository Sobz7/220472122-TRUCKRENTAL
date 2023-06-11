package za.ac.cput.service.impl;

import za.ac.cput.domain.Rental;
import za.ac.cput.repository.RentalRepository;
import za.ac.cput.service.RentalService;

import java.util.Set;

public abstract class RentalServiceImpl implements RentalService {

    private static RentalServiceImpl service = null;

    private static RentalRepository repository = null;

    private RentalServiceImpl() {
        repository = RentalServiceImpl.getRepository();
    }

    private static RentalRepository getRepository() {
        repository = RentalServiceImpl.getRepository();
        return null;
    }

    public static RentalServiceImpl getService() {
        if (service == null) {
            service = new RentalServiceImpl() {
                @Override
                public boolean delete() {
                    return false;
                }
            };
        }
        return service;
    }

    @Override
    public Rental create(Rental rental) {
        Rental created = repository.create(rental);
        return created;
    }
    @Override
    public Rental read(String rentalID) {
        Rental readRental = repository.read(rentalID);
        return readRental;
    }
    @Override
    public Rental update(Rental rental) {
        Rental updated = repository.update(rental);
        return updated;
    }

    @Override
    public boolean delete(int rentalID) {
        boolean success = repository.delete(Integer.parseInt(String.valueOf(rentalID)));
        return success;
    }
    @Override
    public Set<Rental> getAll(){return repository.getAll();}
}
    
