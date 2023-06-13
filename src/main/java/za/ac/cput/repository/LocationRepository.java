package za.ac.cput.repository;
/*Author Ayanda Phumzile Khoza
Student Number 218057172
 */
import za.ac.cput.domain.Location;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LocationRepository implements ILocationRepository {

    private static LocationRepository repository = null;

    private Set<Location> locationDB =null;

    private LocationRepository()
    {
        locationDB= new HashSet<Location>();
    }

    public static LocationRepository getRepository()
    {
        if (repository == null) {
            repository = new LocationRepository();
        }

        return repository;

    }


                @Override
                public Location create(Location location) {
                    boolean success= locationDB.add(location) ;
                if(!success)
                    return null;
                return location;
                }

                @Override
                public Location read(String locationId) {
                    for (Location e : locationDB) {
                        if (Objects.equals(e.getLocationId(), locationId)) {
                            return e;
                        }
                        continue;
                    }
                    return null;
                }

                @Override
                public Location update(Location location) {
                    Location oldLocation = read(String.valueOf(location.getLocationId()));
                    if(oldLocation != null) {
                        locationDB.remove(oldLocation);
                        locationDB.add(location);
                        return location;
                    }
                    return null;
                }

                @Override
                public boolean delete()
            {
                    return false;
                }
                public boolean delete(String locationId) {
                    Location locationToDelete = read(locationId);
                    if (locationToDelete == null)
                        return false;
                    Location categoryToDelete = null;
                    locationDB.remove(categoryToDelete);
                    return true;
                }

                @Override
                public Set<Location> getAll() {
                    return locationDB;
                }
            }







