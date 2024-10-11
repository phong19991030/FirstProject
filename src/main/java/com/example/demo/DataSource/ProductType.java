package com.example.demo.DataSource;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
public class ProductType extends BaseModel {
    @NotEmpty(message = "Tên loại đồ dùng không được để trống")
    private String name;

    @NotEmpty(message = "Mã loại đồ dùng không được để trống")
    @Size(max = 10, message = "Mã loại đồ dùng không được quá 10 ký tự")
    private String code;

    private String description;
}

