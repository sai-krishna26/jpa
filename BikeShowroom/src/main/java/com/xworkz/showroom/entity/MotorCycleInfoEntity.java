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

@NamedQuery(name="getMotorCycleByNameAndEngineType",query = "select n from MotorCycleInfoEntity n where n.name=:name AND n.engineType=:engineType")
@NamedQuery(name="getByMileage",query="select n from MotorCycleInfoEntity n where n.mileage=:mileage")


@NamedQuery(name="getAllMotorCycleInfo",query="select n from MotorCycleInfoEntity n")
@NamedQuery(name="getByName",query="select n from MotorCycleInfoEntity n where n.name='bajaj'")
@NamedQuery(name="getByEngineType",query="select n from MotorCycleInfoEntity n where n.engineType='petrol'")
@NamedQuery(name="getByPrice",query="select n from MotorCycleInfoEntity n where n.price=1000000")

@NamedQuery(name="updateNameById",query = "update MotorCycleInfoEntity n set n.name='pulsar' where n.id=1")
@NamedQuery(name="updateEngineTypeByName",query = "update MotorCycleInfoEntity n set n.engineType='hybrid' where n.name='pulsar'")
@NamedQuery(name="updateMileageByEngineType",query = "update MotorCycleInfoEntity n set n.mileage='50' where n.engineType='petrol'")

@NamedQuery(name="deleteByName",query = "delete from MotorCycleInfoEntity n where n.name='yamaha'")
@NamedQuery(name="deleteByEngineType",query = "delete from MotorCycleInfoEntity n where n.engineType='hybrid'")


public class MotorCycleInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "engineType")
    private String engineType;

    @Column(name="mileage")
    private String mileage;

    @Column(name="price")
    private Double price;

    @Column(name="quantity")
    private Integer quantity;

}
