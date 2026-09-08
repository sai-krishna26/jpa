package com.xworkz.showroom.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MotorCycleInfoDto {
    private String name;
    private String engineType;
    private Integer mileage;
    private Double price;
    private Integer quantity;

    public MotorCycleInfoDto(String name, String engineType, Integer mileage, Double price, Integer quantity) {
        this.name = name;
        this.engineType = engineType;
        this.mileage = mileage;
        this.price = price;
        this.quantity = quantity;
    }
}
