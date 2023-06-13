package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Category;
//import factory.CategoryFactory;
//import static factory.CategoryFactory.createCategory;

class CategoryFactoryTest {
    @Test
    public void  test(){
        Category category= CategoryFactory.createCategory( "2021M","Furniture",20,"Drop Side");
        System.out.println(category.toString());
        assertNotNull(category);
    }
}