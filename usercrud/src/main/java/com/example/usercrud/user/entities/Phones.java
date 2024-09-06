package com.example.usercrud.user.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Phones {

    @Id
    @UuidGenerator
    private String id;

    private String number;

    @Column(name="country_code")
    private String countryCode;

    @Column(name="city_code")
    private String cityCode;

    @ManyToOne(targetEntity = Users.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="users_id", nullable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private Users users;

    public Phones(){
        this.id = UUID.randomUUID().toString();
    }
}
