package za.ac.cput.controller;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import za.ac.cput.domain.Location;
import za.ac.cput.factory.LocationFactory;

public class LocationControllerTest {
    @LocalServerPort
    private int portNumber;

    @Autowired
    private TestRestTemplate restTemplate;

    private Location Location;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        Location = LocationFactory.createLocation(1, "Western Cape, Wynberg", "854 Voice Street");
        baseUrl = "http://localhost:" + portNumber + "/Location";
    }

    @Test
    @Order(1)
    void save()
    {
        String url = baseUrl + "save";
        ResponseEntity<Location> response = restTemplate.postForEntity(url, Location, Location.class);
        assertAll(
            () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
            () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read()
    {
        String url = baseUrl + "read/" + Location.getLocationId();
        ResponseEntity<Location> response = restTemplate.getForEntity(url, Location.class);
        assertAll(
            () -> assertEquals(HttpStatus.OK, response.getStatusCode())
        );
    }

    @Test
    @Order(3)
    void findAll()
    {
        String url = baseUrl + "find-all";
        ResponseEntity<Location[]> response = restTemplate.getForEntity(url, Location[].class);
        assertAll(
            () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
            () -> assertTrue(response.getBody().length > 0)
        );
    }

    @Test
    @Order(4)
    void delete()
    {
        String url = baseUrl + "delete/" + Location.getLocationId();
        restTemplate.delete(url, Location, Location.class);
    }
}
