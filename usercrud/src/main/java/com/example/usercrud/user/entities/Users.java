package com.example.usercrud.user.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(generator ="UUID")
    @Column(name ="id", updatable = false, nullable = false)
    private UUID id;

    private String name;

    @Column(name="email_address", unique = true, nullable = false)
    private String email;

    private String password;
    private LocalDate created;
    private LocalDate modified;

    @Column(name="last_login")
    private LocalDate lastLogin;

    private String token;

    @Column(name="is_active")
    private boolean isActive;

    @OneToMany(targetEntity = Phones.class, fetch = FetchType.LAZY, mappedBy = "users")
    private List<Phones> phones;

}



