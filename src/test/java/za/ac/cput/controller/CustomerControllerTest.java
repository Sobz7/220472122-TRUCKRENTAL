package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.CustomerService;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {


    @Autowired
    private CustomerService service;

    private static final Customer customer = CustomerFactory.createCustomer(  "emily", "smith" , "emily@gmail.com" , "14 bowden road, obs", "756983");

    @Autowired
    private TestRestTemplate restTemplate;
    //private final String basedURL = "http://localhost:8080/customer";
    private final String basedURL = "http://localhost:8080/customer";


    @Test
    void a_create() {
        String url = basedURL +  "/create";
        System.out.println(url);
        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(url, customer, Customer.class);
        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
        assertNotNull(postResponse.getStatusCode(), String.valueOf(HttpStatus.OK));
        Customer savedCustomer  = postResponse.getBody();
        // assertEquals(customer.getCustomerId(), savedCustomer.getCustomerId());
        System.out.printf("saved data " + savedCustomer );
        System.out.println(postResponse.getBody());
    }

//    @Test
//    void b_read() {
//        String url = basedURL + "/read/" + customer.getCustomerId(); // Make sure the customer ID is correct here
//        System.out.println("URL: " + url);
//        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);
////assertNotNull(response.getBody());
//       // assertEquals(customer.getCustomerId(), response.getBody().getCustomerId());
//        System.out.println(response.getBody());
//    }

    @Test
    void b_read(){
        String url = basedURL + "/read/" + customer.getCustomerId();
        System.out.println("URL: "+ url);
        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        //assertNotNull(response.getBody());
// Add assertions for the retrieved customer's properties if needed

    }


    @Test
    void c_update() {
        Customer updated = new Customer.Builder().copy(customer).setName("nana").setSurname("nadia").setEmail("nadia@gmail.com").setAddress("mowbray").setPassword("123456789").build();

        String url = basedURL + "/update/" + customer.getCustomerId();
        System.out.printf("URL" + url);
        System.out.printf("post data" + updated);
        ResponseEntity<Customer> response = restTemplate.postForEntity(url, updated, Customer.class);
        // System.out.println(response);
        //assertNotNull(response.getBody());
    }

    //@Disabled
    @Test
    void e_delete(){
        String readUrl = basedURL + "/read/" + customer.getCustomerId();
        ResponseEntity<Customer> readResponse = restTemplate.getForEntity(readUrl, Customer.class);
        // assertEquals(HttpStatus.NOT_FOUND, readResponse.getStatusCode());


    }

    @Test
    void d_getAll() {
        String url = basedURL + "/getAll";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Customer> customer = new HttpEntity<>(null, headers);
        ResponseEntity<List<Customer>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>() {});
        //assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
// You can add further assertions here for the list of customers

        System.out.println("Show all");
        System.out.println(customer);
        System.out.println(response.getBody());
        // System.out.println("Response: " + response);

        //System.out.println(service.getAll());


//        System.out.println("Response status code: " + response.getStatusCode());
//        System.out.println("Response body: " + response.getBody());
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
    }


}