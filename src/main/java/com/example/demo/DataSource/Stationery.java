package com.example.demo.DataSource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "stationery")
public class Stationery  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String code;
    private String name;
    private Long typeId;

    private Integer minAge;

    private Integer maxAge;

    @Lob
    @Column(name = "image")
    private byte[] image;

    private int price;
}
