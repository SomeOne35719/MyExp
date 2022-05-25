package com.example.demo.service;

import com.example.demo.сlient.APIClient;
import com.example.demo.dto.RegistrationDto;
import com.example.demo.dto.Response;
import com.example.demo.dto.UploadDocumentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class Service {

    private final APIClient client;
    @Value("${demo.key}")
    private String key;

    @JsonSerialize
    @SneakyThrows
    public void callApi(MultipartFile file) {
        Response response = registrationStart();
        System.out.println(response);
        UploadDocumentDto documentDto = map(response);
        documentDto.setFile(file);
        System.out.println(client.uploadDocuments(documentDto));
    }

    @SneakyThrows
    private Response registrationStart() {
        RegistrationDto registrationDto = createRegistrationDto();

        ObjectMapper objectMapper = new ObjectMapper();

        String str = objectMapper.writeValueAsString(registrationDto);
        System.out.println(str);

        String response = client.registrationStart(str);
        JSONObject object = new JSONObject(response);

        return Response.builder()
                .status(object.getString("status"))
                .userHash(object.getString("user_hash"))
                .userId(String.valueOf(object.getLong("user_id")))
                .build();
    }

    private RegistrationDto createRegistrationDto() {
        return RegistrationDto.builder()
                .key(key)
                .first_name("Yurii")
                .last_name("Fedorko")
                .email("someone35719@gmail.com")
                .phone("+380970553158")
                .gender(0)
                .zip("81500")
                .middle_name("")
                .phone2("")
                .city("Lviv")
                .address("Lvivska street 130")
                .birthday_day("19")
                .birthday_month("05")
                .birthday_year("1998")
                .document_number("FE097675")
                .country_nationality("UA")
                .country_residence("UA")
                .build();
    }

    private UploadDocumentDto map(Response source) {
        return UploadDocumentDto.builder()
                .user_hash(source.getUserHash())
                .check_id(source.getUserId())
                .build();

    }
}
