package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Lob;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String code;
    private String name;
    private Long typeId;
    private int minAge;
    private int maxAge;
    private byte[] image;
    private int price;
}

