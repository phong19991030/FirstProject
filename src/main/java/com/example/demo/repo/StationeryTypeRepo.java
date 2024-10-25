package com.example.demo.repo;

import com.example.demo.DataSource.StationeryType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationeryTypeRepo extends JpaRepository<StationeryType, Long> {

    Page<StationeryType> findByNameContaining(String name, Pageable pageable);

    StationeryType findByCode(String code);
}
