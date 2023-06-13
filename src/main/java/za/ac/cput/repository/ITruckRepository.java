package za.ac.cput.repository;

import za.ac.cput.domain.Category;
import za.ac.cput.domain.Truck;

import java.util.Set;

public interface ITruckRepository extends IRepository<Truck, String>{
     Truck read(String truckId);

    default boolean delete(String truckId){
        return false;
    }

    public Set<Truck> getAll();
}
