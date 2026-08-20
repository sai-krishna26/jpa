package com.xworkz.redbus.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="payment_info")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="payment_method")
    private String paymentMethod;

    @Column(name="amount")
    private  Double amount;

    @Column(name="upi_id")
    private Long upiId;
}
