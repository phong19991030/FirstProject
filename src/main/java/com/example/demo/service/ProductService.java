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
import java.util.Optional;

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
        // Kiểm tra nếu sản phẩm đã tồn tại
        if (product.getId() != null) {
            Product existingProduct = getProductById(product.getId());

            // Nếu không có ảnh mới, giữ lại ảnh cũ
            if (imgFile.isEmpty()) {
                product.setImgPath(existingProduct.getImgPath());
            } else {
                // Nếu có ảnh mới, lưu ảnh mới
                saveImageFile(product, imgFile);
            }
        } else {
            // Kiểm tra trùng mã sản phẩm
            Optional<Product> productWithSameCode = productRepo.findByCode(product.getCode());
            if (productWithSameCode.isPresent()) {
                throw new IllegalArgumentException("Mã sản phẩm đã tồn tại. Vui lòng nhập mã khác.");
            }

            // Nếu là sản phẩm mới, lưu ảnh mới (nếu có)
            if (!imgFile.isEmpty()) {
                saveImageFile(product, imgFile);
            }
        }

        // Lưu sản phẩm
        productRepo.save(product);
    }


    private void saveImageFile(Product product, MultipartFile imgFile) {
        try {
            String fileName = imgFile.getOriginalFilename();
            Path uploadPath = Paths.get(uploadDir);

            // Kiểm tra và tạo thư mục nếu nó chưa tồn tại
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);  // Tạo thư mục
            }

            // Đường dẫn đầy đủ của file
            Path filePath = uploadPath.resolve(fileName);

            // Lưu file lên hệ thống
            Files.copy(imgFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Đặt tên file cho product
            product.setImgPath(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            // Bạn có thể thêm logic ném exception hoặc xử lý lỗi ở đây
            throw new RuntimeException("Lưu file không thành công: " + e.getMessage());
        }
    }


    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}


