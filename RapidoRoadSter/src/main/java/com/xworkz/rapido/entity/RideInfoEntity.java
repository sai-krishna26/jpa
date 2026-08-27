package com.xworkz.rapido.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="ride_info")
@Getter
@Setter
@ToString
public class RideInfoEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="fromm")
    private String from;

    @Column(name="too")
    private String to;

    @Column(name="payment_mode")
    private String paymentMode;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="cost")
    private double cost;

}
