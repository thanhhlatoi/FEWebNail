package com.example.API.service.Imlp;

import com.example.API.dto.response.CloudinaryResponse;
import com.example.API.dto.response.bog.BlogDetailResponse;
import com.example.API.entity.Blog;
import com.example.API.entity.Product;
import com.example.API.exception.FuncErrorException;
import com.example.API.exception.NotFoundException;
import com.example.API.repository.BlogRepository;
import com.example.API.service.BlogService;
import com.example.API.service.CloudinaryService;
import com.example.API.service.ProductService;
import com.example.API.util.FileUploadUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BlogServiceImlp implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private MessageSource messageSource;
    private static final Logger LOGGER = Logger.getLogger(BlogServiceImlp.class.getName());

    @Override
    public List<Blog> getList() {
        return blogRepository.findAll(Sort.by("id").descending());
    }

    @Override
    public Blog createBlog(BlogDetailResponse request) {
        Blog blog = new Blog();
        blog.setTitle(request.getTitle());
        blog.setDescription(request.getDescription());
        blog.setContent(request.getContent());
        blog.setCreateAt(new Timestamp(System.currentTimeMillis()));
        blogRepository.save(blog);
        return blog;
    }
    @Transactional
    public void uploadImage(final Integer id, final MultipartFile file) {
        try {
            final Blog blog = this.blogRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Product not found"));
            FileUploadUtil.assertAllowed(file, FileUploadUtil.IMAGE_PATTERN);
            final String fileName = FileUploadUtil.getFileName(file.getOriginalFilename());
            final CloudinaryResponse response = this.cloudinaryService.uploadFile(file, fileName);
            blog.setImageUrl(response.getUrl());
            blog.setCloudinaryImageId(response.getPublicId());
            this.blogRepository.save(blog);
        } catch (NotFoundException e) {
            LOGGER.log(Level.SEVERE, "Product not found with id: " + id, e);
            throw e;
        } catch (FuncErrorException e) {
            LOGGER.log(Level.SEVERE, "Failed to upload file to Cloudinary", e);
            throw e;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unexpected error occurred", e);
            throw new RuntimeException("Unexpected error occurred: " + e.getMessage());
        }
    }

    @Override
    public Blog updateBlog(Integer id, BlogDetailResponse request) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Blog"));
        blog.setTitle(request.getTitle());
        blog.setDescription(request.getDescription());
        blog.setContent(request.getContent());
        blogRepository.save(blog);
        return blog;
    }

    @Override
    public void deleteBlog(Integer id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Blog"));
        //blog.getTags().remove(this);
        blogRepository.delete(blog);
    }
}
