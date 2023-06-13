package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Truck;
//import factory.CategoryFactory;
class TruckFactoryTest {
    @Test
    public void test() {
        Truck truck = TruckFactory.createTruck("mms", "Ford F-160", 2020, true, "siya2023", 500.0, 2 );
        System.out.println(truck.toString());
        assertNotNull(truck);

    }
}