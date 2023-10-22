package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Category;
import za.ac.cput.domain.Truck;
import za.ac.cput.service.CategoryService;
import za.ac.cput.service.TruckService;

import java.util.Set;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/truck")
public class TruckController {

    @Autowired
    private TruckService truckService;

    @PostMapping("/create")
    Truck create(@RequestBody Truck truck){return truckService.save(truck);}

    @GetMapping("/read/{id}")
    public Truck read(@PathVariable Long id)
    {
        return truckService.getById(id);
    }
    @PostMapping("/update/{id}")
    public Truck update (@PathVariable Long id, @RequestBody Truck truck)
    {
        Truck trucUpdate = truckService.update(id, truck);
        if (trucUpdate == null) {
            return null;
        }
        return truckService.save(trucUpdate);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete (@PathVariable Long id) {truckService.deleteByID(id);
        return true;
    }
    @GetMapping("/getAll")
    public Set<Truck> getAll(){
        return truckService.getAll();
    }

}