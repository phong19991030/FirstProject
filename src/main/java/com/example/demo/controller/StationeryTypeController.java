package com.example.demo.controller;

import com.example.demo.DataSource.StationeryType;
import com.example.demo.service.StationeryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/stationery-types")
public class StationeryTypeController {
    @Autowired
    private StationeryTypeService stationeryTypeService;

    // Danh sách ProductTypes với tìm kiếm và phân trang
    @GetMapping
    public String listProductTypes(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "") String searchName,
                                   Model model) {
        Page<StationeryType> productTypes = stationeryTypeService.searchProductTypesByName(searchName, PageRequest.of(page, size));
        model.addAttribute("productTypes", productTypes);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productTypes.getTotalPages());
        model.addAttribute("searchName", searchName);
        return "stationery-type-list";
    }

    // Hiển thị form tạo mới
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("productType", new StationeryType());
        return "stationery-type-form";
    }

    @PostMapping
    public String saveProductType(@Valid @ModelAttribute StationeryType stationeryType,
                                  BindingResult result, Model model) {

        // Kiểm tra xem mã code đã tồn tại chưa
        if (stationeryTypeService.isCodeExists(stationeryType.getCode(), stationeryType.getId())) {
            result.rejectValue("code", "error.productType", "Mã loại đồ dùng đã tồn tại.");
        }

        // Nếu có lỗi, trả lại form
        if (result.hasErrors()) {
            return "stationery-type-form";
        }

        // Lưu product type nếu không có lỗi
        stationeryTypeService.saveProductType(stationeryType);
        return "redirect:/stationery-types";
    }


    // Hiển thị form sửa ProductType
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        StationeryType stationeryType = stationeryTypeService.getProductTypeById(id);
        model.addAttribute("productType", stationeryType);
        return "stationery-type-form";
    }

    // Xử lý xóa ProductType
    @GetMapping("/delete/{id}")
    public String deleteProductType(@PathVariable("id") long id) {
        stationeryTypeService.deleteProductType(id);
        return "redirect:/stationery-types";
    }
}
