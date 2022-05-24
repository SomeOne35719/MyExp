package com.example.demo.сontroller;

import com.example.demo.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class MyController {
    private final Service service;

    @PostMapping(value = "/uploadFile")
    public ResponseEntity<HttpStatus> register(@RequestPart(required = false) MultipartFile  file) {
        service.callApi(file);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
