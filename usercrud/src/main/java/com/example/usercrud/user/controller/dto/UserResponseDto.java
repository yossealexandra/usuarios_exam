package com.example.usercrud.user.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private UUID id;

    private LocalDate created;

    private LocalDate modified;

    private LocalDate lastLogin;

    private String token;

    private boolean isActive;

}
