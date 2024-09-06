package com.example.usercrud.user.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;

    @NotBlank
    @Email(message = "El correo no es valido")
    private String email;

    @NotNull
    @Size(min = 5, max = 20)
    //@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,20}$", message = "La contraseña no cumple con el formato requerido")
    private String password;

    private LocalDate created;

    private LocalDate modified;

    private LocalDate lastLogin;

    private String token;

    private boolean isActive;

    @Valid
    private List<PhoneDto> phones;

}
