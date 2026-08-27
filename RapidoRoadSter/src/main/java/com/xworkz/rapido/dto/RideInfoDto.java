package com.xworkz.rapido.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class RideInfoDto
{
    private String from;
    private String to;
    private String paymentMode;
    private String customerName;
    private double cost;
}
