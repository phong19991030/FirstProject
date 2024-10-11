package com.example.demo.controller;

import com.example.demo.DataSource.Product;
import com.example.demo.DataSource.ProductType;
import com.example.demo.dto.SearchProductRequest;
import com.example.demo.dto.response.ProductResponse;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping
    public String listProducts(Model model) {
        List<ProductType> types = productTypeService.getAllProductTypes();
        model.addAttribute("productTypes", types);
        return "product-list";
    }


    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        List<ProductType> types = productTypeService.getAllProductTypes();
        model.addAttribute("productTypes", types);
        return "product-form";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute Product product,
                              @RequestParam("imgFile") MultipartFile imgFile,
                              BindingResult result, Model model) {
        try {
            productService.saveOrUpdateProduct(product, imgFile);
        } catch (IllegalArgumentException e) {
            result.rejectValue("code", ".errorproduct", e.getMessage());
        }

        if (result.hasErrors()) {
            model.addAttribute("productTypes", productTypeService.getAllProductTypes());
            return "product-form";
        }

        return "redirect:/products";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("productTypes", productTypeService.getAllProductTypes());
        return "product-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}





