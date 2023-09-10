package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Category;
import za.ac.cput.factory.CategoryFactory;
import za.ac.cput.repository.CategoryRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryServiceTest {
    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryService categoryService;
    public static Category category1 = CategoryFactory.createCategory("Furniture1", 20, "Box truck");
    public static Category category2 = CategoryFactory.createCategory("Furniture2", 59, "Box truck");

    @Test
    @Order(1)
    void save() {
        Category created1 = categoryService.save(category1);
        assertNotNull(created1);
        System.out.println("Created: " + created1);

        Category create2 = categoryService.save(category2);
        assertNotNull(create2);
        System.out.println("Created: " + create2);
    }

    @Test
    @Order(2)
    void getById() {
        Category readById = categoryService.getById(category1.getId());
        assertNotNull(readById);
        System.out.println("Read: " + readById);
    }

    @Test
    @Order(3)
    void update() {
        Category updateCategory = category1.toBuilder().truckSize(150).description("Furniture 13").build();
        Category savedCategory = categoryService.save(updateCategory);
        assertNotNull(updateCategory);
        System.out.println("Update: " + updateCategory);
    }

    @Test
    @Order(4)
    void deleteByID() {
        categoryService.deleteByID(category2.getId());
        System.out.println("Deleted:");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("Get All: ");
        System.out.println(categoryService.getAll());
    }
}