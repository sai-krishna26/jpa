package com.xworkz.Quick.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class RegisterDto {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotBlank(message = "Confirm Password cannot be blank")
    private String confirmPassword;

    @NotNull(message = "Graduation Date cannot be null")
    private LocalDate graduationDate;

    @NotBlank(message = "Institute cannot be blank")
    private String institute;

}
