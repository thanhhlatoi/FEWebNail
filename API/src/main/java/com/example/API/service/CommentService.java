package com.example.API.service;


import com.example.API.dto.request.CommentCreateRequest;

import com.example.API.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment (CommentCreateRequest request);
    Comment updateComment(Integer commentId,CommentCreateRequest request);
    List<Comment> getAll();
    void deleteComment(Integer commentId);
}
