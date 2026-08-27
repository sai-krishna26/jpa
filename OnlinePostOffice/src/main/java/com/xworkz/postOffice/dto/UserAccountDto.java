package com.xworkz.postOffice.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDto {
    private String name;
    private  String gender;
    private int age;
    private long accountNumber;
}
