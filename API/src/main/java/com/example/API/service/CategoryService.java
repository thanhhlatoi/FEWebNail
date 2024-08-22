package com.example.API.service;

import com.example.API.dto.request.CategoryCreateRequest;
import com.example.API.entity.Category;

import java.util.List;

public interface CategoryService {
     Category createCategory (CategoryCreateRequest request);
     Category updateCategory(Integer id,CategoryCreateRequest request);
    List<Category> getAll();
    void deleteCategory(Integer id);

}
