package com.web.restdemo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDto implements Serializable {

    private static final long serialVersionUID = 6968881297485972796L;

    private Long id;

    private String firstName;

    private String lastName;

    public CustomerDto() {
    }

    public CustomerDto(final Long id, final String firstName, final String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
