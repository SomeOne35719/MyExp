package com.example.demo.сlient;

import com.example.demo.FeignSupportConfig;
import com.example.demo.dto.UploadDocumentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "myFeign",
            url = "${demo.external.link}",
            configuration = {FeignSupportConfig.class/*- MultipartJackson2HttpMessageConverter.class*/})
public interface APIClient {

    @PostMapping( value = "/auth/base-check", consumes = MediaType.ALL_VALUE,  produces = MediaType.TEXT_PLAIN_VALUE)
    String registrationStart(String json);

    @PostMapping(value = "/auth/send-document", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadDocuments(@RequestPart UploadDocumentDto dto);

}
