package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    //@JsonProperty("status")
    private String status;

   // @JsonProperty("user_hash")
    private String user_hash;

    //@JsonProperty("user_id")
    private String user_id;
}
