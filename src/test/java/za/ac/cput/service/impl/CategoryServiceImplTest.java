/*
package za.ac.cput.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Category;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.factory.CategoryFactory;
import za.ac.cput.repository.impl.CategoryRepository;


import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class CategoryServiceImplTest {

    private static CategoryRepository repository = CategoryRepository.getRespository();
    private static Category category= CategoryFactory.createCategory("66hh11","Furniture",30,"Large");

    @Test
    void a_create() {
        Category created = repository.create(category);
        assertEquals(category.getCategoryId(),created.getCategoryId());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        Category read= repository.read(category.getCategoryId());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Category updated = new Category.Builder().copy(category).setDescription("Wood")
                .setTruckType("Curtain Side")
                .setTruckSize(60)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated:" + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(category.getCategoryId());
        assertTrue(success);
        System.out.println("Deleted: " + success);


    }

    @Test
    void d_getAll() {
        System.out.println("show all:");
        System.out.println(repository.getAll());
    }

}*/
