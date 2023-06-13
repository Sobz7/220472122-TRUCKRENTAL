package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Brand;
import za.ac.cput.factory.BrandFactory;

import static org.junit.jupiter.api.Assertions.*;

class BrandRepositoryTest {

    private static BrandRepository repository = BrandRepository.getRepository();

    static Brand brand = BrandFactory.createBrand(353, "UD Truck", "Pick up truck", "Black");

    @Test
    void create() {
        Brand created = repository.create(brand);
        assertEquals(brand.getBrandId(), created.getBrandId());
        System.out.println("Create:" + created);
    }

    @Test
    void read() {
        Brand read = repository.read(String.valueOf(brand.getBrandId()));
        assertNotNull(read);
        System.out.println("Read:" + read);
    }


    @Test
    void update() {
        Brand updated = new Brand.Builder().copy(brand).setModel("Pick up truck")
                .setBrandName("UD Truck")
                .setColor("Black")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Update:" + updated);
    }
    @Test
    void delete() {
        boolean success = repository.delete(String.valueOf(brand.getLocationId()));
        assertTrue(success);
        System.out.println("Deleted:" + success);
}
    @Test
    void getAll() {
        System.out.println("show all :");
        System.out.println(repository.getAll());
    }
}