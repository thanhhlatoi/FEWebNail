package com.example.API.dto.response.bog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogDetailResponse {
    private Integer id;
    private String title;
    private String content;
    private String description;
    private Timestamp createAt;
    private String imageUrl;
    private String cloudinaryImageId;
}
