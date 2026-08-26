package com.xworkz.slice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="account_info")
@ToString
public class AccountDetailsEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;

    @Column(name="account_number")
    private Integer accountNumber;

    @Column(name="account_holder_id")
    private String accountHolderId;

    @Column(name="account_holder_name")
    private String accountHolderName;

    @Column(name="age")
    private Integer age;

    @Column(name="gender")
    private String gender;
}
