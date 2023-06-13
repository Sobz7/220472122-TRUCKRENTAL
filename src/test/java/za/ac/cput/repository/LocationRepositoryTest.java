package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Brand;
import za.ac.cput.domain.Location;
import za.ac.cput.factory.BrandFactory;
import za.ac.cput.factory.LocationFactory;

import static org.junit.jupiter.api.Assertions.*;
import static za.ac.cput.repository.BrandRepositoryTest.brand;

class LocationRepositoryTest {

    private static LocationRepository repository = LocationRepository.getRepository();

    private static Location location = LocationFactory.createLocation(667, "Cape Town", "Plein Street");


    @Test
    void create() {
        Location created = repository.create(location);
        assertEquals(brand.getBrandId(),created.getLocationId());
        System.out.println("Create:" + created);
    }

    @Test
    void read() {
        Location read= repository.read(String.valueOf(location.getLocationId()));
        assertNotNull(read);
        System.out.println("Read:" + read);
    }


    @Test
   void update() {
        Location updated = new Location.Builder().copy(location).setLocationName("Cape Town")
                .setLocationId(353)
                .setAddress("Plein Street")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Update:" + updated);
    }

    @Test
    void delete() {
        boolean success = repository.delete(String.valueOf(location.getLocationId()));
        assertTrue(success);
        System.out.println("Deleted:" + success);

    }

    @Test
    void getAll() {
        System.out.println("show all :");
        System.out.println(repository.getAll());
    }
}