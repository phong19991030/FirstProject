package com.example.demo.service;

import com.example.demo.DataSource.Product;
import com.example.demo.dto.SearchProductRequest;
import com.example.demo.dto.response.ProductResponse;
import com.example.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Value("${upload.dir}")
    private String uploadDir;

    public Page<ProductResponse> searchProducts(SearchProductRequest searchProductRequest, int page, int size) {
        // Sắp xếp theo createTime theo thứ tự giảm dần (DESC)
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");

        // Tạo Pageable với page, size và sort theo createTime
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<ProductResponse> productPage = productRepo.searchProducts(searchProductRequest, pageable);

        // Nếu không có bản ghi nào, trả về một Page rỗng
        if (productPage.getTotalElements() == 0) {
            return new PageImpl<>(new ArrayList<>(), pageable, 0);
        }

        return productPage;
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public void saveOrUpdateProduct(Product product, MultipartFile imgFile) {
        // Kiểm tra xem sản phẩm đã tồn tại trong cơ sở dữ liệu chưa
        if (product.getId() != null) {
            Product existingProduct = getProductById(product.getId());
            // Nếu không có ảnh mới, giữ lại ảnh cũ
            if (imgFile.isEmpty()) {
                product.setImgPath(existingProduct.getImgPath());
            } else {
                // Nếu có ảnh mới, lưu ảnh mới
                try {
                    String fileName = imgFile.getOriginalFilename();
                    Path filePath = Paths.get(uploadDir, fileName);
                    Files.copy(imgFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                    product.setImgPath(fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            // Nếu là sản phẩm mới, lưu ảnh mới (nếu có)
            if (!imgFile.isEmpty()) {
                try {
                    String fileName = imgFile.getOriginalFilename();
                    Path filePath = Paths.get(uploadDir, fileName);
                    Files.copy(imgFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                    product.setImgPath(fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Lưu sản phẩm
        productRepo.save(product);
    }


    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}


