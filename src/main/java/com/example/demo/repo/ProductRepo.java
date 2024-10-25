package com.example.demo.repo;

import com.example.demo.DataSource.Stationery;
import com.example.demo.dto.SearchProductRequest;
import com.example.demo.dto.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Stationery, Long> {
    @Query(value = "SELECT new com.example.demo.dto.response.ProductResponse(" +
            "p.id" +
            ", p.code" +
            ", p.name" +
            ", p.typeId" +
            ", p.maxAge" +
            ", p.minAge" +
            ", p.image" +
            ", p.price) " +
            "FROM " +
            "   Stationery p " +
//            "JOIN ProductType pt ON p.typeId = pt.id " +
            "WHERE " +
            "   (:#{#searchRequest.age} IS NULL OR p.minAge <= :#{#searchRequest.age}) AND " +
            "   (:#{#searchRequest.minPrice} IS NULL OR p.price >= :#{#searchRequest.minPrice}) AND " +
            "   (:#{#searchRequest.maxPrice} IS NULL OR p.price <= :#{#searchRequest.maxPrice}) " +
            "")
    Page<ProductResponse> searchProducts(@Param("searchRequest") SearchProductRequest searchRequest, Pageable pageable);

    Optional<Stationery> findByCode(String code);
}


