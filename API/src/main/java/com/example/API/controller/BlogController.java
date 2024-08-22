package com.example.API.controller;

import com.example.API.dto.request.ProductCreateRequest;
import com.example.API.dto.response.bog.BlogDetailResponse;
import com.example.API.entity.Blog;
import com.example.API.service.BlogService;
import com.example.API.service.Imlp.BlogServiceImlp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogServiceImlp blogServiceImlp;

    @GetMapping("/")
    public ResponseEntity<List<Blog>> getList(){
        List<Blog> list = blogService.getList();

        return ResponseEntity.ok(list);

    }
    @PostMapping("h")
    public ResponseEntity<?> create(@RequestBody final BlogDetailResponse request) {
        return ResponseEntity.ok(this.blogService.createBlog(request));
    }
    @PostMapping("/image/{id}")
    public ResponseEntity<?> uploadImage(@PathVariable final Integer id, @RequestPart final MultipartFile file) {
        this.blogServiceImlp.uploadImage(id, file);
        return ResponseEntity.ok("Upload successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> update(@PathVariable Integer id, @RequestBody BlogDetailResponse request){

        Blog blog = blogService.updateBlog(id, request);

        return ResponseEntity.ok(blog);

    }

}
