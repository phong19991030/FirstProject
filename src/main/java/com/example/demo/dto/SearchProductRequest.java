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
    private Float minPrice;
    private Float maxPrice;
    private Long productTypeId;
    private Integer status;

}

