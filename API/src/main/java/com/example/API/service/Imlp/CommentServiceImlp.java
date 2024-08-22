package com.example.API.service.Imlp;

import com.example.API.dto.request.CommentCreateRequest;
import com.example.API.entity.*;
import com.example.API.exception.NotFoundException;
import com.example.API.repository.CommentRepository;
import com.example.API.repository.CustomerRepository;
import com.example.API.repository.ProductRepository;
import com.example.API.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class CommentServiceImlp implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Comment createComment(CommentCreateRequest request) {
        Comment comment = new Comment();
        comment.setTitle(request.getTitle());
        comment.setRating(request.getRating());
        Customer customer = customerRepository.findById(request.getCustomerID()).orElseThrow(()-> new NotFoundException("Not Found Customer With Id: " + request.getCustomerID()));
        comment.setCustomer(customer);
        Product product = productRepository.findById(request.getProductID()).orElseThrow(()-> new NotFoundException("Not Found Customer With Id: " + request.getProductID()));
        comment.setProduct(product);
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public Comment updateComment(Integer commentId, CommentCreateRequest request) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new NotFoundException("Not Found Category With Id: " + commentId));
        comment.setTitle(request.getTitle());
        comment.setRating(request.getRating());
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll(Sort.by("commentId").descending());// Trả về null nếu không tìm thấy
    }

    @Override
    public void deleteComment(Integer commentId) {

    }

}
