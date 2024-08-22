package com.example.API.service;

import com.example.API.dto.response.bog.BlogDetailResponse;
import com.example.API.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getList();
    Blog createBlog(BlogDetailResponse request);
    Blog updateBlog(Integer id,BlogDetailResponse request);
    void deleteBlog(Integer id);
}
