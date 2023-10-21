package za.ac.cput.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Truck;
import za.ac.cput.repository.TruckRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class TruckService {
    private TruckRepository truckRepository;
    @Autowired
    public TruckService(TruckRepository truckRepository){this.truckRepository = truckRepository;}

    public Truck save(Truck truck){return truckRepository.save(truck);}
    public Truck getById(Long id){return truckRepository.findById(id).orElse(null);}
    public Truck update(Long id, Truck updateTruck){
        Truck truckExisting = truckRepository.findById(id).orElse(null);
        if (truckExisting == null) {
            return null;
        }
        if (updateTruck.getModel() != null) {
            truckExisting.setModel(updateTruck.getModel());
        }
        if (updateTruck.getYear() > 1000) {
            truckExisting.setYear(updateTruck.getYear());
        }

        truckExisting.setAvailability(updateTruck.isAvailability());

        if (updateTruck.getBrandId() > 0) {
            truckExisting.setBrandId(updateTruck.getBrandId());
        }
        if (updateTruck.getCurrentMileage() > 0.0) {
            truckExisting.setCurrentMileage(updateTruck.getCurrentMileage());
        }
        return truckRepository.save(truckExisting);}
    public void deleteByID(Long id){truckRepository.deleteById(id);}
    public Set<Truck> getAll(){
        System.out.println("get all trucks");
        return new HashSet<>(truckRepository.findAll());}


}
