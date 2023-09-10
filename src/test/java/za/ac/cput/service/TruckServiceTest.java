package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Truck;
import za.ac.cput.factory.TruckFactory;
import za.ac.cput.repository.TruckRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TruckServiceTest {
    private TruckRepository truckRepository;
    @Autowired
    public TruckService truckService;
    private static Truck truck1 = TruckFactory.createTruck("Ford", 2017, true, "CP567EC", 456, 23 );
    private static Truck truck2 =TruckFactory.createTruck("Mazda", 2012, true, "CS16WC", 501, 50 );

    @Test
    @Order(1)
    void save() {
        Truck created1 = truckService.save(truck1);
        assertNotNull(created1);
        System.out.println("Created: " + created1);

        Truck created2 = truckService.save(truck2);
        assertNotNull(created2);
        System.out.println("Created:" + created2);
    }
    @Test
    @Order(2)
    void getById(){
        Truck readById = truckService.getById(truck1.getTruckId());
        assertNotNull(readById);
        System.out.println("Read: " + readById);
    }

    @Test
    @Order(3)
    void update(){
        Truck updateTruck = truck1.toBuilder().year(2005).availability(false).build();
        Truck saveTruck = truckService.save(updateTruck);
        assertNotNull(updateTruck);
        System.out.println("Read: " + updateTruck);
    }

    @Test
    @Order(4)
    void deleteById(){
        truckService.deleteByID(truck2.getTruckId());
        System.out.println("Deleted:");
    }
    @Test
    @Order(5)
    void getAll(){
        System.out.println("Get All: ");
        System.out.println(truckService.getAll());
    }
}