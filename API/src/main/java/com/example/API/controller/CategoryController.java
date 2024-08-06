package com.example.API.controller;

import com.example.API.entity.Category;
import com.example.API.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("add")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("update/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteCategory(@PathVariable Integer id) {
        return categoryService.deleteCategory(id);
    }

    @GetMapping("list")
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.get(id);
    }

    @GetMapping("/hihi")
    public String hihi(){
        return "hihi";
    }
}
