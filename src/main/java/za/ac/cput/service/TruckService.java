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
    public Truck getById(String id){return truckRepository.findById(id).orElse(null);}
    public Truck update(Truck updateTruck){return truckRepository.save(updateTruck);}
    public void deleteByID(String id){truckRepository.deleteById(id);}
    public Set<Truck> getAll(){return new HashSet<>(truckRepository.findAll());}
}