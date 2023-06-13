package za.ac.cput.repository;

import java.util.Set;
import za.ac.cput.domain.Category;
public interface ICategoryRepository extends IRepository<Category, String> {
    Category read(String categoryId);
        default boolean delete(String categoryId){
        return false;
        }
    public Set<Category> getAll();
}
