package co.za.entelect.restclientdemo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDto implements Serializable {

    private static final long serialVersionUID = -3858917673795591683L;

    private Long id;

    private String firstName;

    private String lastName;

    public CustomerDto() {
    }

    public CustomerDto(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
