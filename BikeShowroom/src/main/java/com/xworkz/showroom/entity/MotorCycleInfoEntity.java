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

@NamedQuery(name="getAllMotorCycleInfo",query="select n from MotorCycleInfoEntity n")


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
