package com.example.demo.сlient;

import com.example.demo.dto.RegistrationDto;
import com.example.demo.dto.Response;
import com.example.demo.dto.Response2;
import com.example.demo.dto.UploadDocumentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;

@FeignClient(name = "myFeign",
            url = "${demo.external.link}")
public interface APIClient {

    @PostMapping( value = "/auth/base-check", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = "text/plain;charset=utf-8")
    Response registrationStart(RegistrationDto dto);

    @PostMapping(value = "/auth/send-document", consumes = "application/json")
    Response2 uploadDocuments(UploadDocumentDto dto);
}
