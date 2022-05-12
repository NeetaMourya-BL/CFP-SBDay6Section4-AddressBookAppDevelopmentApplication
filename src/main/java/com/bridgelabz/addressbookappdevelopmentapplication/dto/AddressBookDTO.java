package com.bridgelabz.addressbookappdevelopmentapplication.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AddressBookDTO {
    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="Person name Invalid it should be start with capital letter")
    @NotEmpty(message = "Person Name can't be null")
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public int zip;
    public String phoneNumber;
    public String email;

    public AddressBookDTO(String firstName, String lastName, String address, String city, String state, int zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "AddressBookDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}