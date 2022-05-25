package com.example.demo.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadDocumentDto {

    private String user_hash;

    private String check_id;

    private MultipartFile file;
}
