package com.example.API.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreateRequest {
    @NotNull(message = "Tên Khach Hang rỗng")
    @NotEmpty(message = "Tên Khach Hang rỗng")
    @Size(min=5,max=30,message="Độ dài danh mục từ 5-30 ký tự")
    private String name;
    @NotNull(message="Email rỗng")
    @NotEmpty(message="Email rỗng")
    @Size(min =5,max=30, message="Email từ 5-30 ký tự")
    @Email(message="Email không hợp lệ")
    private String email;
    @Size(min = 10,max = 12, message = "so dien thoai khong hop le")
    private String phone;
    private LocalDate birthDay;
    private boolean enabled;
}
