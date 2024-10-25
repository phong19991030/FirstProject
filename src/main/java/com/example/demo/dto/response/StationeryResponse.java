package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StationeryResponse {
    private Long id;
    private String code;
    private String name;
    private String typeName;
    private int minAge;
    private int maxAge;
    private byte[] image;
    private int price;
}

