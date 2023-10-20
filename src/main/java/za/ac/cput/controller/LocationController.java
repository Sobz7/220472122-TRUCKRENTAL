package za.ac.cput.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import za.ac.cput.domain.Location;
import za.ac.cput.service.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {
    private final LocationService service;

    @Autowired
    public LocationController(LocationService service) {
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<Location> save(@RequestBody Location Location)
    {
        Location LocationRecord = null;
        try {
            LocationRecord = service.create(LocationRecord);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(LocationRecord);
    }

    @GetMapping("read/{LocationId}")
    public ResponseEntity<Location> read(@PathVariable String LocationId)
    {
        Location LocationRecord = service.read(LocationId);
        return ResponseEntity.ok(LocationRecord);
    }

    @GetMapping("find-all")
    public ResponseEntity<List<Location>> findAll(@PathVariable String LocationId)
    {
        List<Location> LocationRecord = service.getAll();
        return ResponseEntity.ok(LocationRecord);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@RequestBody Location Location)
    {
        service.delete(String.valueOf(Location.getLocationId())); 
        return ResponseEntity.noContent().build();
    }
}
