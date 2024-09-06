package com.example.usercrud.user.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDto {

    @NotBlank
    private String number;

    private String countryCode;

    private String cityCode;
}
