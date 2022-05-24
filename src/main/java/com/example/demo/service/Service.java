package com.example.demo.service;

import com.example.demo.сlient.APIClient;
import com.example.demo.dto.RegistrationDto;
import com.example.demo.dto.Response;
import com.example.demo.dto.UploadDocumentDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class Service {

    private final APIClient client;
    @Value("${demo.key}")
    private String key;
    @SneakyThrows
    public void callApi(MultipartFile file) {
        Response response = registrationStart();
        UploadDocumentDto documentDto = map(response);
        documentDto.setBytes(file.getBytes());
        client.uploadDocuments(documentDto);
    }

    private Response registrationStart() {
        RegistrationDto registrationDto = createRegistrationDto();
        return client.registrationStart(registrationDto);
    }

    private RegistrationDto createRegistrationDto() {
        return RegistrationDto.builder()
                .key(key)
                .first_name("Yurii")
                .last_name("Fedorko")
                .email("someone35719@gmail.com")
                .phone("+380970553158")
                .gender(0)
                .birthday_day("19")
                .birthday_month("5")
                .birthday_year("1998")
                .country_nationality("3166-1")
                .country_residence("3166-1")
                .build();
    }

    private UploadDocumentDto map(Response source) {
        return UploadDocumentDto.builder()
                .userHash(source.getUser_hash())
                .userID(source.getUser_id())
                .build();

    }
}
