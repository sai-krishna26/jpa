package com.xworkz.slice.dto;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class AccountDetailsDto {
    private int accountNumber;
    private String accountHolderId;
    private String accountHolderName;
    private int age;
    private String gender;
}
