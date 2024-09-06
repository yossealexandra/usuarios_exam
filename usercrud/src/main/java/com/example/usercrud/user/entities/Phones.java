package com.example.usercrud.user.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Phones {

    @Id
    private UUID id;

    private String number;

    @Column(name="country_code")
    private String countryCode;

    @Column(name="city_code")
    private String cityCode;

    @ManyToOne(targetEntity = Users.class, cascade = CascadeType.PERSIST)
    private Users users;

    public Phones(){
        this.id = UUID.randomUUID();
    }
}
