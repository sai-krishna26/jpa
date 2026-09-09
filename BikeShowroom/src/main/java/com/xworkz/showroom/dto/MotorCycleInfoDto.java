package com.xworkz.showroom.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
//@RequiredArgsConstructor
public class MotorCycleInfoDto {

    @NotBlank(message = "Name cannot be null")
    @Size(min=3, max=20, message="the name should be between 3 and 20 characters")
    private String name;

    @NotBlank(message = "Engine type cannot be null")
    private String engineType;

    @NotNull(message = "Mileage cannot be null")
    @Min(value = 10, message = "Mileage should be at least 10")
    private Integer mileage;

    @NotNull(message = "Price cannot be null")
    private Double price;

    @NotNull(message = "Quantity cannot be null")
    private Integer quantity;

    public MotorCycleInfoDto(String name, String engineType, Integer mileage, Double price, Integer quantity) {
        this.name = name;
        this.engineType = engineType;
        this.mileage = mileage;
        this.price = price;
        this.quantity = quantity;
    }
}
