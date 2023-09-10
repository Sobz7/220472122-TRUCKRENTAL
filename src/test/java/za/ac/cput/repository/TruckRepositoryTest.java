/*
package za.ac.cput.repository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Truck;
import za.ac.cput.factory.TruckFactory;
 import za.ac.cput.repository.impl.TruckRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
class TruckRepositoryTest {
  private static TruckRepository repository= TruckRepository.getRespository();
  private static Truck truck= TruckFactory.createTruck("1000ML","Ford F-160",2013,true,"GP1234",500.00,6);
   @Test
    void a_create() {
      Truck created= repository.create(truck);
      assertEquals(truck.getTruckId(), created.getTruckId());
      System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
      Truck read= repository.read(truck.getTruckId());
      assertNotNull(read);
      System.out.println("Read:" +read);
    }

    @Test
    void c_update() {
      Truck updated = new Truck.Builder().copy(truck).setModel("Toyota")
              .setLicensePlate("CPT678")
              .setYear(2016)
              .build();
      assertNotNull(repository.update(updated));
      System.out.println("Updated:" + updated);
    }


    @Test
    void e_Delete() {
      boolean success = repository.delete(truck.getTruckId());
      assertTrue(success);
      System.out.println("Deleted:" + success);

    }

    @Test
    void d_getAll() {
      System.out.println("show all:");
      System.out.println(repository.getAll());
    }
}*/
