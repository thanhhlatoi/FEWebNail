package com.example.API.service;

import com.example.API.entity.Category;

import java.util.List;

public interface CategoryService {
    public Category addCategory (Category category);

    // chinh sua nhan vien
    public Category updateCategory(Integer id , Category  category);

    // xoa nhan vien
    public boolean deleteCategory(Integer id);

    // ham lay danh sach nhan vien
    public List<Category> getAll();

    // ham lay ra 1 nhan vien

    public Category get(Integer id);
}
