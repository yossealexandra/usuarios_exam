package com.example.usercrud.user.service;

import com.example.usercrud.user.controller.dto.PhoneDto;
import com.example.usercrud.user.controller.dto.UserDto;
import com.example.usercrud.user.controller.dto.UserResponseDto;
import com.example.usercrud.user.entities.Phones;
import com.example.usercrud.user.entities.Users;
import com.example.usercrud.user.persistence.PhoneRepository;
import com.example.usercrud.user.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PhoneRepository phoneRepository;

    BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> registerUser(UserDto user){
        Users userRequest = new Users();
        Optional<Users> res = userRepository.findUserByEmail(user.getEmail());
        HashMap<String, Object> response = new HashMap<>();

        if(res.isPresent()){
            response.put("message:", "El correo ya esta registrado");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
        userRequest.setId(UUID.randomUUID());
        userRequest.setName(user.getName());
        userRequest.setEmail(user.getEmail());
        userRequest.setPassword(encoder.encode(user.getPassword()));
        userRequest.setCreated(LocalDate.now());
        userRequest.setLastLogin(user.getCreated());
        userRequest.setModified(LocalDate.now());
        userRequest.setToken(UUID.randomUUID());
        if (!user.getPhones().isEmpty()) userRequest.setPhones(build(user.getPhones()));

        this.userRepository.save(userRequest);

        response.put("data", mapResponse(userRequest));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    private UserResponseDto mapResponse(Users user){
        UserResponseDto res = new UserResponseDto();

        res.setId(user.getId());
        res.setCreated(user.getCreated());
        res.setModified(user.getModified());
        res.setLastLogin(user.getLastLogin());
        res.setToken(user.getToken());

        return res;
    }

    private List<Phones> build(List<PhoneDto> phones){
        List<Phones> listPhone = new ArrayList<>();
        Phones resPhone = new Phones();

        phones.forEach(phone -> {
            resPhone.setNumber(phone.getNumber());
            resPhone.setCountryCode(phone.getCountryCode());
            resPhone.setCityCode(phone.getCityCode());
            this.phoneRepository.save(resPhone);
        });

        listPhone.add(resPhone);

        return listPhone;
    }
}
