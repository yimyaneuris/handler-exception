package com.example.handlerexception.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Employee employee;
}
