package com.xworkz.showroom.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="motorcycle_info")
@ToString
public class MotorCycleInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "engine_type")
    private String engine_type;

    @Column(name="mileage")
    private String mileage;

    @Column(name="price")
    private double price;

}
