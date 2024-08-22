package com.example.API.dto.request;

import com.example.API.entity.Customer;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateRequest {
    @NotNull(message = "Nhan Xet rỗng")
    @NotEmpty(message = "TNhan Xet rỗng")
    @Size(min=5,max=30,message="Độ dài danh mục từ 5-30 ký tự")
    private String title;
    private int rating;
    private Integer customerID;
    private Integer productID;
}
