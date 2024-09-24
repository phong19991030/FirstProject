package com.example.demo.repo;

import com.example.demo.DataSource.Product;
import com.example.demo.dto.SearchProductRequest;
import com.example.demo.dto.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query(value = "SELECT new com.example.demo.dto.response.ProductResponse(p.id, p.code, p.name, p.age, p.price, pt.name, p.imgPath, p.status) " +
            "FROM Product p JOIN ProductType pt ON p.productTypeId = pt.id " +
            "WHERE (:#{#searchRequest.name} IS NULL OR p.name LIKE %:#{#searchRequest.name}%) AND " +
            "(:#{#searchRequest.age} IS NULL OR p.age = :#{#searchRequest.age}) AND " +
            "(:#{#searchRequest.minPrice} IS NULL OR p.price >= :#{#searchRequest.minPrice}) AND " +
            "(:#{#searchRequest.maxPrice} IS NULL OR p.price <= :#{#searchRequest.maxPrice}) AND " +
            "(:#{#searchRequest.productTypeId} IS NULL OR p.productTypeId = :#{#searchRequest.productTypeId}) AND " +
            "(:#{#searchRequest.status} IS NULL OR p.status = :#{#searchRequest.status})",
            countQuery = "SELECT COUNT(p) FROM Product p JOIN ProductType pt ON p.productTypeId = pt.id " +
                    "WHERE (:#{#searchRequest.name} IS NULL OR p.name LIKE %:#{#searchRequest.name}%) AND " +
                    "(:#{#searchRequest.age} IS NULL OR p.age = :#{#searchRequest.age}) AND " +
                    "(:#{#searchRequest.minPrice} IS NULL OR p.price >= :#{#searchRequest.minPrice}) AND " +
                    "(:#{#searchRequest.maxPrice} IS NULL OR p.price <= :#{#searchRequest.maxPrice}) AND " +
                    "(:#{#searchRequest.productTypeId} IS NULL OR p.productTypeId = :#{#searchRequest.productTypeId}) AND " +
                    "(:#{#searchRequest.status} IS NULL OR p.status = :#{#searchRequest.status})",
            nativeQuery = false)
    Page<ProductResponse> searchProducts(@Param("searchRequest") SearchProductRequest searchRequest, Pageable pageable);
}

