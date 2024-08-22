package com.example.API.controller;

import com.example.API.dto.request.CategoryCreateRequest;
import com.example.API.entity.Category;
import com.example.API.repository.CategoryRepository;
import com.example.API.service.CategoryService;
import com.example.API.service.Imlp.CategoryServiveImlp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryServiveImlp Service;

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryCreateRequest request){
        Category category = categoryService.createCategory(request);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @Valid @RequestBody CategoryCreateRequest request){
        Category category = categoryService.updateCategory(id, request);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("soa thanh cong");
    }


    @GetMapping("/")
    public ResponseEntity<?> getListCategory(){
        List<Category> categories = categoryService.getAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return Service.get(id);
    }

    @GetMapping("/hihi")
    public String hihi(){
        return "hihi";
    }
}
