package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Category;
import za.ac.cput.service.CategoryService;

import java.util.Set;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    Category create(@RequestBody Category category){return categoryService.save(category);}

    @GetMapping("/read/{id}")
    public Category read(@PathVariable Long id)
    {
        return categoryService.getById(id);
    }

    @PostMapping("/update/{id}")
    public Category update (@PathVariable Long id, @RequestBody Category category)
    {
        Category updateCategory = categoryService.update(id, category);
        if (updateCategory == null){
            return null;
        }
        return categoryService.save(updateCategory);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete (@PathVariable Long id) {categoryService.deleteByID(id);
        return true;
    }

    @GetMapping("/getAll")
    public Set<Category> getAll(){
        return categoryService.getAll();
    }
}