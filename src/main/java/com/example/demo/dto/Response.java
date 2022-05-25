package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Response {
    @JsonProperty("status")
    private String status;

    @JsonProperty("user_hash")
    private String userHash;

    @JsonProperty("user_id")
    private String userId;
}
