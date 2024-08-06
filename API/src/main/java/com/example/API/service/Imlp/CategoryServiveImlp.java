package com.example.API.service.Imlp;

import com.example.API.entity.Category;
import com.example.API.repository.CategoryRepository;
import com.example.API.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiveImlp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        if(category != null){
            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public Category updateCategory(Integer id, Category category) {
        if(category != null){
            Category category1  = categoryRepository.getById(id);
            if(category1 != null){
                category1.setName(category.getName());
                return categoryRepository.save(category1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteCategory(Integer id) {
        if(id >= 1){
            Category category = categoryRepository.getById(id);
            if(category != null){
                categoryRepository.delete(category);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category get(Integer id) {
        return categoryRepository.findById(id)
                .orElse(null); // Trả về null nếu không tìm thấy
    }

}
