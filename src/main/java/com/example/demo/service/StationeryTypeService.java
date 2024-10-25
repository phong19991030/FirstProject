package com.example.demo.service;

import com.example.demo.DataSource.StationeryType;
import com.example.demo.repo.StationeryTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationeryTypeService {
    @Autowired
    private StationeryTypeRepo stationeryTypeRepo;

    public List<StationeryType> getAllProductTypes() {
        return stationeryTypeRepo.findAll();
    }

    public void saveProductType(StationeryType stationeryType) {
        stationeryTypeRepo.save(stationeryType);
    }

    public StationeryType getProductTypeById(Long id) {
        return stationeryTypeRepo.findById(id).orElse(null);
    }

    public void deleteProductType(Long id) {
        stationeryTypeRepo.deleteById(id);
    }

    public Page<StationeryType> getAllProductTypes(Pageable pageable) {
        return stationeryTypeRepo.findAll(pageable);
    }

    public Page<StationeryType> searchProductTypesByName(String name, Pageable pageable) {
        return stationeryTypeRepo.findByNameContaining(name, pageable);
    }

    // Kiểm tra xem mã code đã tồn tại chưa
    public boolean isCodeExists(String code, Long id) {
        StationeryType existingStationeryType = stationeryTypeRepo.findByCode(code);
        // Nếu mã đã tồn tại, nhưng không phải của product hiện tại (khi update)
        return existingStationeryType != null && !existingStationeryType.getId().equals(id);
    }
}
