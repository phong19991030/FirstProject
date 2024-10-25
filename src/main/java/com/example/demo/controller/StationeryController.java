package com.example.demo.controller;

import com.example.demo.DataSource.Stationery;
import com.example.demo.DataSource.ProductType;
import com.example.demo.dto.SearchProductRequest;
import com.example.demo.dto.response.ProductResponse;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/products")
public class StationeryController {

    @Autowired
    private ProductService stationeryService;

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping
    public String listProducts(Model model) {
//        List<ProductType> types = productTypeService.getAllProductTypes();
//        model.addAttribute("productTypes", types);
        return "product-list";
    }


    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Stationery());
        List<ProductType> types = productTypeService.getAllProductTypes();
        model.addAttribute("productTypes", types);
        return "product-form";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute Stationery product,
                              @RequestParam("imgFile") MultipartFile imgFile,
                              BindingResult result, Model model) {
        try {
            stationeryService.saveOrUpdateProduct(product, imgFile);
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
        Stationery product = stationeryService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("productTypes", productTypeService.getAllProductTypes());
        return "product-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        stationeryService.deleteProduct(id);
        return "redirect:/products";
    }

}





