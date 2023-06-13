package za.ac.cput.repository;
import za.ac.cput.domain.Category;

import java.util.HashSet;
import java.util.Set;

public class CategoryRepository implements ICategoryRepository{
    private static CategoryRepository respository = null;
    private  Set<Category> categoryDB= null;
    private  CategoryRepository(){
        categoryDB= new HashSet<Category>();
    }
    public static CategoryRepository getRespository(){
        if (respository == null){
            respository =new CategoryRepository();

        }
        return  respository;
    }

    @Override
    public Category create(Category category) {
       boolean success= categoryDB.add(category) ;
       if(!success)
        return null;
       return category;
    }

    @Override
    public Category read(String categoryId) {
        for (Category e : categoryDB) {
            if(e.getCategoryId().equals(categoryId))
            return e;
        }
        return null;
    }
    @Override
    public Category update(Category category) {
        Category oldCategory = read(category.getCategoryId());
        if (oldCategory != null) {
            categoryDB.remove(oldCategory);
            categoryDB.add(category);
            return category;
        }
        return null;
    }
    @Override
    public boolean delete() {
        return false;
    }
    public boolean delete( String categoryId){
        Category categoryToDelete= read(categoryId);
        if (categoryToDelete == null)
            return false;
        categoryDB.remove(categoryToDelete);
        return true;

    }
    @Override
    public Set<Category> getAll() {
        return categoryDB;
    }
}
