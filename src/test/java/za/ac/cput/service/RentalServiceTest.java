// Rental Service Test Class
// Author: Sobantu Malotana (220472122)
// Date: 07 June 2023

package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Rental;
import za.ac.cput.factory.RentalFactory;
import za.ac.cput.repository.RentalRepository;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class RentalServiceTest {

    private static RentalRepository service = RentalRepository.getRepository();
    private static Rental rental = RentalFactory.createRental(122,12,123,"2023-04-04","2023-05-30",42750.0);

    @Test
    void a_create() {
        Rental created = service.create(rental);
        assertNotNull(rental.getRentalId());
        System.out.println("Create : "+ created);
    }

    @Test
    void b_read() {
        Rental read = service.read((Integer) rental.getRentalId());
        assertNotNull(read);
        System.out.println("Read : "+ read);
    }

    @Test
    void c_update() {
        Rental updated = new Rental.Builder().copy(rental).setStartDate(LocalDate.parse("2023-04-05"))
                .setEndDate(LocalDate.parse("2023-05-31"))
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated : "+ updated);
    }

    @Test
    void e_delete() {
        boolean success = service.delete((Integer) rental.getRentalId());
        assertTrue(success);
        System.out.println("Deleted :"+ success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all :");
        System.out.println(service.getAll());
    }
}
