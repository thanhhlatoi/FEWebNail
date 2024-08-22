package com.example.API.controller;

import com.example.API.dto.request.CommentCreateRequest;


import com.example.API.entity.Comment;

import com.example.API.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<?> createComment(@Valid @RequestBody CommentCreateRequest request){
        Comment comment = commentService.createComment(request);
        return ResponseEntity.ok(comment);
    }
    @PutMapping("update/{commentId}")
    public ResponseEntity<?> updateCustomer(@PathVariable Integer commentId, @Valid @RequestBody CommentCreateRequest request){
        Comment comment = commentService.updateComment(commentId, request);
        return ResponseEntity.ok(comment);
    }
    @GetMapping("hihi")
    public String hihi(){
        return "asdada";
    }
    @GetMapping("list")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.commentService.getAll());
    }
}
