package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Category;
import za.ac.cput.repository.CategoryRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository){this.categoryRepository = categoryRepository;}

    public Category save(Category category){return categoryRepository.save(category);}
    public Category getById(Long id){return categoryRepository.findById(id).orElse(null);}
    public Category update(Long id, Category updateCategory){
        Category categoryExisting = categoryRepository.findById(id).orElse(null);

        if (categoryExisting == null) {
            return null;
        }

        if (updateCategory.getDescription() != null) {
            categoryExisting.setDescription(updateCategory.getDescription());
        }
        if (updateCategory.getTruckType() != null){
            categoryExisting.setTruckType(updateCategory.getTruckType());
        }
        if (updateCategory.getTruckSize() > 0) {
            categoryExisting.setTruckSize(updateCategory.getTruckSize());
        }

        return categoryRepository.save(categoryExisting);}
    public void deleteByID(Long id){
        categoryRepository.deleteById(id);}
    public Set<Category> getAll(){return new HashSet<>(categoryRepository.findAll());}
}
