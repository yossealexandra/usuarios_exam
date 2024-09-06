package com.example.usercrud.user.persistence;

import com.example.usercrud.user.entities.Phones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phones, Long> {

}
