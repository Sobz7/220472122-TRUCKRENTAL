package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Category;
import za.ac.cput.service.CategoryService;

import java.util.Set;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    Category create(@RequestBody Category category){return categoryService.save(category);}

    @GetMapping("/read/{id}")
    public Category read(@PathVariable String id)
    {
        return categoryService.getById(id);
    }

    @PostMapping("/update")
    public Category update (@RequestBody Category category)
    {
        return categoryService.update(category);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete (@PathVariable String id) {categoryService.deleteByID(id);
        return true;
    }

    @GetMapping("/getAll")
    public Set<Category> getAll(){
        return categoryService.getAll();
    }
}
