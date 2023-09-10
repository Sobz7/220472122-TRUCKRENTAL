package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.Category;
import za.ac.cput.domain.Truck;
import za.ac.cput.factory.CategoryFactory;
import za.ac.cput.factory.TruckFactory;
import za.ac.cput.repository.CategoryRepository;
import za.ac.cput.repository.TruckRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
class TruckControllerTest {
    public static Truck truck1 = TruckFactory.createTruck("Ram", 2013, false,"CF675CP",600.56,78);
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private TruckRepository truckRepository;
    private final String basedURL = "http://localhost:8080/truck";


    @Test
    void create() {
        String url = basedURL + "/create";
        ResponseEntity<Truck> postResponse = testRestTemplate.postForEntity(url, truck1,Truck.class);
        System.out.println(postResponse);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertNotNull(postResponse.getStatusCode(), String.valueOf(HttpStatus.OK));
        Truck saveTruck = postResponse.getBody();

        System.out.println("Saved: "+ saveTruck);
        System.out.println(postResponse.getBody());
    }

    @Test
    void read() {
        String url = basedURL + "/read/" + truck1.getTruckId();
        System.out.println("URL: "+ url);
        ResponseEntity<Truck> response = testRestTemplate.getForEntity(url,Truck.class);

        System.out.println(response.getBody());
    }

    @Test
    void update() {
        Truck updateTruck = truck1.toBuilder().model("Toyota").licensePlate("CF568EC").currentMileage(300.76).build();

        String url = basedURL + "/update/" + truck1.getTruckId();
        System.out.printf("URL" + url);
        System.out.printf("post data" + updateTruck);
        ResponseEntity<Truck> response = testRestTemplate.postForEntity(url, updateTruck, Truck.class);
        System.out.println(response);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    void delete() {
        String url = basedURL + "/delete/" + truck1.getTruckId();
        System.out.printf("URL" + url);
        testRestTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = basedURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(basedURL, HttpMethod.GET, entity, String.class);
        System.out.print("show all");
        System.out.println(response.getBody());
    }
}