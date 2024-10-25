package com.example.demo.controller;

import com.example.demo.DataSource.Stationery;
import com.example.demo.DataSource.StationeryType;

import com.example.demo.service.StationeryTypeService;
import com.example.demo.service.StationeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/stationerys")
public class StationeryController {

    @Autowired
    private StationeryService stationeryService;

    @Autowired
    private StationeryTypeService stationeryTypeService;

    @GetMapping
    public String listProducts(Model model) {
//        List<ProductType> types = productTypeService.getAllProductTypes();
//        model.addAttribute("productTypes", types);
        return "stationery-list";
    }


    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Stationery());
        List<StationeryType> types = stationeryTypeService.getAllProductTypes();
        model.addAttribute("productTypes", types);
        return "stationery-form";
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
            model.addAttribute("productTypes", stationeryTypeService.getAllProductTypes());
            return "stationery-form";
        }

        return "redirect:/stationerys";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Stationery product = stationeryService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("productTypes", stationeryTypeService.getAllProductTypes());
        return "stationery-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        stationeryService.deleteProduct(id);
        return "redirect:/stationerys";
    }

}





