package com.example.demo.repo;

import com.example.demo.DataSource.Stationery;
import com.example.demo.dto.SearchStationeryRequest;
import com.example.demo.dto.response.StationeryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StationeryRepo extends JpaRepository<Stationery, Long> {
    @Query(value = "SELECT new com.example.demo.dto.response.StationeryResponse(" +
            "p.id" +
            ", p.code" +
            ", p.name" +
            ", pt.name" +
            ", p.maxAge" +
            ", p.minAge" +
            ", p.image" +
            ", p.price) " +
            "FROM " +
            "   Stationery p " +
            "JOIN StationeryType pt ON p.typeId = pt.id " +
            "WHERE " +
            "   (:#{#searchRequest.age} IS NULL OR p.minAge <= :#{#searchRequest.age}) AND " +
            "   (:#{#searchRequest.minPrice} IS NULL OR p.price >= :#{#searchRequest.minPrice}) AND " +
            "   (:#{#searchRequest.maxPrice} IS NULL OR p.price <= :#{#searchRequest.maxPrice}) " +
            "")
    Page<StationeryResponse> searchProducts(@Param("searchRequest") SearchStationeryRequest searchRequest, Pageable pageable);

    Optional<Stationery> findByCode(String code);
}


