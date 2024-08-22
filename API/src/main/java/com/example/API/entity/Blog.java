package com.example.API.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Blog")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(name = "description",columnDefinition = "TEXT")
    private String description;
    @Column(name = "content",columnDefinition = "TEXT")
    private String content;
    private Timestamp createAt;
    private String imageUrl;

    private String cloudinaryImageId;
}
