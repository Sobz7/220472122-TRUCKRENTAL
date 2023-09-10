package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Category;
import za.ac.cput.domain.Truck;
import za.ac.cput.service.CategoryService;
import za.ac.cput.service.TruckService;

import java.util.Set;

@RestController
@RequestMapping("/truck")
public class TruckController {

    @Autowired
    private TruckService truckService;

    @PostMapping("/create")
    Truck create(@RequestBody Truck truck){return truckService.save(truck);}

    @GetMapping("/read/{id}")
    public Truck read(@PathVariable String id)
    {
        return truckService.getById(id);
    }
    @PostMapping("/update")
    public Truck update (@RequestBody Truck truck)
    {
        return truckService.update(truck);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete (@PathVariable String id) {truckService.deleteByID(id);
        return true;
    }
    @GetMapping("/getAll")
    public Set<Truck> getAll(){
        return truckService.getAll();
    }

}
