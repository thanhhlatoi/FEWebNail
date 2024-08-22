package com.example.API.controller;

import com.example.API.dto.request.ProductCreateRequest;
import com.example.API.dto.request.ProductUpdateRequest;
import com.example.API.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/list")

    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/{id}")

    public ResponseEntity<?> findById(@PathVariable final Integer id) {
        return ResponseEntity.ok(this.service.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody final ProductCreateRequest request) {
        return ResponseEntity.ok(this.service.createProduct(request));
    }

    @PostMapping("/image/{id}")
    public ResponseEntity<?> uploadImage(@PathVariable final Integer id, @RequestPart final MultipartFile file) {
        this.service.uploadImage(id, file);
        return ResponseEntity.ok("Upload successfully");
    }

    @PutMapping("/{id}")

    public ResponseEntity<?> update(@PathVariable final Integer id, @RequestBody final ProductUpdateRequest request) {
        return ResponseEntity.ok(this.service.updateProduct(id,request));
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<?> delete(@PathVariable final Integer id) {
        this.service.deleteProduct(id);
        return ResponseEntity.ok("Delete successfully");
    }
    @GetMapping("/hihi")
    public String hihi(){
        return "hihi";
    }
}
