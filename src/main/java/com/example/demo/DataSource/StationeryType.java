package com.example.demo.DataSource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
public class StationeryType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "Mã loại đồ dùng không được để trống")
    @Size(max = 10, message = "Mã loại đồ dùng không được quá 10 ký tự")
    private String code;

    @NotEmpty(message = "Tên loại đồ dùng không được để trống")
    private String name;

    private String description;
}

