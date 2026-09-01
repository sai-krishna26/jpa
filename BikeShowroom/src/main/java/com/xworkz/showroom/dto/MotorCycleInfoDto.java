package com.xworkz.showroom.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MotorCycleInfoDto {
    private String name;
    private String engineType;
    private String mileage;
    private double price;
}
