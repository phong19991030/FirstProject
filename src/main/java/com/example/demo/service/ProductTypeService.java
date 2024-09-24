package com.example.demo.service;

import com.example.demo.DataSource.ProductType;
import com.example.demo.repo.ProductTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepo productTypeRepo;

    public List<ProductType> getAllProductTypes() {
        return productTypeRepo.findAll();
    }

    public void saveProductType(ProductType productType) {
        productTypeRepo.save(productType);
    }

    public ProductType getProductTypeById(Long id) {
        return productTypeRepo.findById(id).orElse(null);
    }

    public void deleteProductType(Long id) {
        productTypeRepo.deleteById(id);
    }

    public Page<ProductType> getAllProductTypes(Pageable pageable) {
        return productTypeRepo.findAll(pageable);
    }

    public Page<ProductType> searchProductTypesByName(String name, Pageable pageable) {
        return productTypeRepo.findByNameContaining(name, pageable);
    }

}
