package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Category;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CategoryFactory;
import za.ac.cput.repository.CategoryRepository;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
class CategoryControllerTest {

    public static Category category1 = CategoryFactory.createCategory("Furniture1", 20, "Box truck");
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private CategoryRepository categoryRepository;
    private final String basedURL = "http://localhost:8080/category";


    @Test
    void create() {
        String url = basedURL + "/create";
        ResponseEntity<Category> postResponse = testRestTemplate.postForEntity(url, category1, Category.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertNotNull(postResponse.getStatusCode(), String.valueOf(HttpStatus.OK));
        Category saveCategory = postResponse.getBody();

        System.out.println("Saved: " + saveCategory);
        System.out.println(postResponse.getBody());
    }

    @Test
    void read() {
        String url = basedURL + "/read/" + category1.getId();
        System.out.println("URL: " + url);
        ResponseEntity<Category> response = testRestTemplate.getForEntity(url, Category.class);

        System.out.println(category1);
    }

    @Test
    void update() {
        Category updateCategory = category1.toBuilder().truckSize(20000).description("Furniture 300").build();

        String url = basedURL + "/update/" + category1.getId();
        System.out.println("URL" + url);
        System.out.println("post data" + updateCategory);
        ResponseEntity<Category> response = testRestTemplate.postForEntity(url, updateCategory, Category.class);
        System.out.println("Saved to DB: " + response.getBody());


    }

    @Disabled
    @Test
    void delete() {
        String url = basedURL + "/delete/" + category1.getId();
        System.out.printf("URL" + url);
        testRestTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = basedURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.print("show all");
        System.out.println(response.getBody());
    }
}