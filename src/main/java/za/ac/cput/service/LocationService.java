package za.ac.cput.service;

import java.util.List;

import za.ac.cput.domain.Location;

public interface LocationService extends IService<Location, String>{
    List<Location> getAll();
}
