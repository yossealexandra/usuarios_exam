package com.example.usercrud.user.controller;

import com.example.usercrud.user.controller.dto.UserDto;
import com.example.usercrud.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
@Tag(name= "Users resource")
public class UserController {

    @Autowired
    UserService userService;

    @Operation(summary = "Save a user in Database by a given User body data")
    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDto userDto){
        return this.userService.registerUser(userDto);
    }
}
