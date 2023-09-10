package za.ac.cput.controller;

import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import za.ac.cput.domain.Brand;
import za.ac.cput.factory.BrandFactory;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BrandControllerTest {
    
    @LocalServerPort
    private int portNumber;

    @Autowired
    private TestRestTemplate restTemplate;

    private Brand brand;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        brand = BrandFactory.createBrand(1, "Volvo", "VNL Globetroller", "WHITE");
        baseUrl = "http://localhost:" + portNumber + "/brand";
    }

    @Test
    @Order(1)
    void save()
    {
        String url = baseUrl + "save";
        ResponseEntity<Brand> response = restTemplate.postForEntity(url, brand, Brand.class);
        assertAll(
            () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
            () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read()
    {
        String url = baseUrl + "read/" + brand.getBrandId();
        ResponseEntity<Brand> response = restTemplate.getForEntity(url, Brand.class);
        assertAll(
            () -> assertEquals(HttpStatus.OK, response.getStatusCode())
        );
    }

    @Test
    @Order(3)
    void findAll()
    {
        String url = baseUrl + "find-all";
        ResponseEntity<Brand[]> response = restTemplate.getForEntity(url, Brand[].class);
        assertAll(
            () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
            () -> assertTrue(response.getBody().length > 0)
        );
    }

    @Test
    @Order(4)
    void delete()
    {
        String url = baseUrl + "delete/" + brand.getBrandId();
        restTemplate.delete(url, brand, Brand.class);
    }
}
