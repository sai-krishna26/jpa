package com.xworkz.showroom.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MotorCycleInfoDto {
    private String name;
    private String engine_type;
    private String mileage;
    private double price;
}
