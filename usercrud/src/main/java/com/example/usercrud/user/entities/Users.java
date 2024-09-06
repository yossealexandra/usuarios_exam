package com.example.usercrud.user.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @UuidGenerator
    private String id;

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

    @OneToMany(targetEntity = Phones.class, fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
    private List<Phones> phones;

}



