package com.example.demo.controller;

import com.example.demo.dto.SearchStationeryRequest;
import com.example.demo.dto.response.StationeryResponse;
import com.example.demo.service.StationeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stationerys")
public class StationeryApiController {

    @Autowired
    private StationeryService stationeryService;

    @GetMapping
    public Page<StationeryResponse> getProducts(SearchStationeryRequest searchStationeryRequest,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        return stationeryService.searchProducts(searchStationeryRequest, page, size);
    }

    @GetMapping("{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        byte[] image = stationeryService.getImageById(id);

        if (image == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }
}


