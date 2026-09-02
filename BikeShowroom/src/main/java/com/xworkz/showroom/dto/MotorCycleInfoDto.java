package com.xworkz.showroom.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MotorCycleInfoDto {
    private String name;
    private String engineType;
    private String mileage;
    private double price;
    private int quantity;

    public MotorCycleInfoDto(String name, String engineType, String mileage, double price, int quantity) {
        this.name = name;
        this.engineType = engineType;
        this.mileage = mileage;
        this.price = price;
        this.quantity = quantity;
    }
}
