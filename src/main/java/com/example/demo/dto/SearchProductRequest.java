package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchProductRequest {
    private String name;
    private Integer age;
    private Integer minPrice;
    private Integer maxPrice;
    private int typeId;
    private Integer status;

}

