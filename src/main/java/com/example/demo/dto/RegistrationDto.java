package com.example.demo.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class RegistrationDto {

    private String key;

    private String first_name;

    private String last_name;

    private String middle_name;

    private String email;

    private String phone;

    private String phone2;

    private Integer gender;

    private String birthday_day;

    private String birthday_month;

    private String birthday_year;

    private String country_nationality;

    private String country_residence;

    private String city;

    private String address;

    private String zip;

    private String document_number;
}
