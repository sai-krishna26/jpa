package com.xworkz.redbus.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="invoice_info")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="booking_id")
    private Integer bookingId;

    @Column(name="invoice_number")
    private String invoiceNumber;

    @Column(name="travel_date")
    private LocalDate travelDate;

    @Column(name="amount")
    private Double amount;

    @Column(name="payment_status")
    private Boolean paymentStatus;
}
