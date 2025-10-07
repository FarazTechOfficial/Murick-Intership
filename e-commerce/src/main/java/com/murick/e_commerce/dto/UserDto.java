package com.murick.e_commerce.dto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
