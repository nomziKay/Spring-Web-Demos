package com.web.restdemo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class  Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    public Customer() {
    }

    public Customer(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
