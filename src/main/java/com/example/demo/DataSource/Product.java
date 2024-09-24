package com.example.demo.DataSource;

//import com.datasource.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity
public class Product extends BaseModel {
    private String code;
    private String name;
    private Integer age;
    private Float price;
    private Long productTypeId;
    private String imgPath;
}
