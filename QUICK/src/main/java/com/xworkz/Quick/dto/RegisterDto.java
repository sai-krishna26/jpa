package com.xworkz.Quick.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class RegisterDto {

    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private LocalDate graduationDate;
    private String institute;

}
