package com.example.demo.DataSource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity
public class ProductType extends BaseModel {
    private String name;
}

