package za.ac.cput.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import za.ac.cput.domain.Location;
import za.ac.cput.factory.LocationFactory;
import za.ac.cput.repository.ILocationRepository;
import za.ac.cput.service.LocationService;

public class LocationServiceImpl implements LocationService{
    private ILocationRepository LocationRepository;

    
    @Autowired
    public LocationServiceImpl(ILocationRepository LocationRepository) 
    {
        this.LocationRepository = LocationRepository;
    }

    @Override
    public Location create(Location Location) {
        return LocationRepository.save(
            LocationFactory.createLocation(
                Location.getLocationId(), 
                Location.getLocationName(), 
                Location.getAddress())
        );
    }

    @Override
    public Location read(String id) {
        return LocationRepository.findById(id).get();
    }

    @Override
    public Location update(Location Location) {
        return LocationRepository.save(Location);
    }

    @Override
    public void delete(String id) {
        LocationRepository.delete(read(id));
    }

    @Override
    public List<Location> getAll() {
        return LocationRepository.findAll();
    }
}
