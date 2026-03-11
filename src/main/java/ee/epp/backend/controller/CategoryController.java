package ee.epp.backend.controller;

import ee.epp.backend.entity.Category;
import ee.epp.backend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*") // turvaviga
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping("categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("categories")
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PostMapping("categories/list")
    public List<Category> addCategories(@RequestBody List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }

    @DeleteMapping("categories/{id}")
    public List<Category> deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return categoryRepository.findAll();
    }

}