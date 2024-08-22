package com.example.API.service.Imlp;

import com.example.API.dto.request.CategoryCreateRequest;
import com.example.API.entity.Category;
import com.example.API.exception.NotFoundException;
import com.example.API.repository.CategoryRepository;
import com.example.API.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiveImlp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryCreateRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category updateCategory(Integer id, CategoryCreateRequest request) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Category With Id: " + id));
        category.setName(request.getName());
        categoryRepository.save(category);
        return category;
    }

    @Override
    public List<Category> getAll() {
        List<Category> list = categoryRepository.findAll(Sort.by("id").descending());
        return list;
    }


    @Override
    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Category With Id: " + id));
        categoryRepository.delete(category);
    }

    public Category get(Integer id) {
        return categoryRepository.findById(id)
                .orElse(null); // Trả về null nếu không tìm thấy
    }

}
