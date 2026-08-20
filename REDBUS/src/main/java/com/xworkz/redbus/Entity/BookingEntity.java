package com.xworkz.redbus.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name="booking_info")
public class BookingEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="from")
    private String from;

    @Column(name="to")
    private String to;

    @Column(name="date")
    private LocalDate date;

    @Column(name="is_for_women")
    private Boolean isForWomen;
}
