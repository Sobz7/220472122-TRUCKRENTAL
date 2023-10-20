package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private  CustomerServiceImpl service ;
    private static Customer customer = CustomerFactory.createCustomer("raymond", "walker" , "ray@gmail.com" , "observatory", "1687532");



    @Test
    void a_create() {

        Customer created = service.create(customer);

        assertNotNull(created.getCustomerId(), created.getCustomerId());
        System.out.println("create: " + created);
    }

    @Test
    void b_read() {
        Customer read2 = service.read(customer.getCustomerId());
        assertNotNull(read2);
        System.out.println("read: " + read2);

    }

    @Test
    void c_update() {


        Customer updated = new Customer.Builder().copy(customer).setName("Burger").setSurname("Naidoo").setEmail("Kruben@outlook.com").setAddress("rondebosch").setPassword("78945612").build();

        updated = service.update(updated);
        assertNotNull(service.update(updated));
        System.out.println(updated); //updated.getCustomerId());

    }

//    @Test
//    void e_delete() {
//
//        service.delete(customer.getCustomerId());
//        assertEquals(service.getAll().size(), 57);
//        System.out.println(service.getAll());
//
//    }

    @Test
    void e_delete() {
        // Create a new customer
        Customer created = service.create(customer);

        // Delete the customer
        service.delete(created.getCustomerId());

        // Assert that the customer is deleted
        assertNull(service.read(created.getCustomerId()));
    }

//    @Test
//    void d_getAll() {
//        System.out.println("show all: ");
//        System.out.println(service.getAll());
//
//    }

    @Test
    void d_getAll() {
        Set<Customer> customer = service.getAll();

        assertNotNull(customer);
        assertTrue(customer.size() > 0);
        System.out.println(service.getAll());
        // You can add more assertions as needed to check the retrieved customers.
    }

}