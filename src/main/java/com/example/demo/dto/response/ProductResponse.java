package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String code;
    private String name;
    private Integer age; // Kiểu Integer
    private Float price; // Kiểu Double
    private String productTypeName;
    private String imgPath;
    private Integer status;
}

