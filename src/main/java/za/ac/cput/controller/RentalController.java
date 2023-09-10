package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Rental;
import za.ac.cput.repository.impl.RentalRepository;

import java.util.Optional;
import java.util.Set;

import static org.springframework.http.HttpStatus.FOUND;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping(path = "api/v1/truckrental")
public class RentalController{

    private final RentalRepository repository;
    private org.springframework.http.HttpStatusCode HttpStatusCode;

    public RentalController(RentalRepository repository) {
        this.repository = repository;
    }
    @GetMapping("")
    public Set<Rental> getAll(){
        return repository.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Rental>findById(@PathVariable Integer rentalId){
        return repository.findById(rentalId);

    }

    @ResponseStatus()
    @PostMapping("")
    public void create(@RequestBody Rental rental){
        repository.create(rental);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Rental rental, @PathVariable Integer rentalId){
        if (repository.existsById(rentalId))
            throw new ResponseStatusException(HttpStatusCode, "Rental not found");
    }
}
