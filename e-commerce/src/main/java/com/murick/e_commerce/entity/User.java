package com.murick.e_commerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {
    @Id
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}

//userid| firstName| la