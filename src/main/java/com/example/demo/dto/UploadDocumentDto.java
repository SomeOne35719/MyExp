package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadDocumentDto {

    @JsonProperty("user_hash")
    private String userHash;

    @JsonProperty("check_id")

    private String userID;

    //private MultipartFile file;
    private byte[] bytes;
}
