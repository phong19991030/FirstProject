package com.example.demo.controller;

import com.example.demo.DataSource.ProductType;
import com.example.demo.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product-types")
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping
    public String listProductTypes(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "5") int size,
                                   @RequestParam(defaultValue = "") String searchName,
                                   Model model) {
        Page<ProductType> productTypes = productTypeService.searchProductTypesByName(searchName, PageRequest.of(page, size));
        model.addAttribute("productTypes", productTypes);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productTypes.getTotalPages());
        model.addAttribute("searchName", searchName);
        return "product-type-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("productType", new ProductType());
        return "product-type-form";
    }

    @PostMapping
    public String saveProductType(@ModelAttribute ProductType productType) {
        productTypeService.saveProductType(productType);
        return "redirect:/product-types";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        ProductType productType = productTypeService.getProductTypeById(id);
        model.addAttribute("productType", productType);
        return "product-type-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductType(@PathVariable("id") long id) {
        productTypeService.deleteProductType(id);
        return "redirect:/product-types";
    }
}
