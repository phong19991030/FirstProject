package com.example.demo.repo;

import com.example.demo.DataSource.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepo extends JpaRepository<ProductType, Long> {

    Page<ProductType> findByNameContaining(String name, Pageable pageable);

}
