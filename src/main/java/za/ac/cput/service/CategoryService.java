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
    public Category getById(String id){return categoryRepository.findById(id).orElse(null);}
    public Category update(Category updateCategory){return categoryRepository.save(updateCategory);}
    public void deleteByID(String id){categoryRepository.deleteById(id);}
    public Set<Category> getAll(){return new HashSet<>(categoryRepository.findAll());}
}
