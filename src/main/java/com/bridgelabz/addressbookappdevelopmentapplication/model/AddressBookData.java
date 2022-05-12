package com.bridgelabz.addressbookappdevelopmentapplication.model;

import com.bridgelabz.addressbookappdevelopmentapplication.dto.AddressBookDTO;
import lombok.Data;

public @Data class AddressBookData {

    private int personId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phoneNumber;
    private String email;

    public AddressBookData(int personId, String firstName, String lastName, String address, String city, String state, int zip, String phoneNumber, String email) {
        super();
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public AddressBookData(int personId, AddressBookDTO addressBookDTO) {
        super();
        this.personId = personId;
        this.firstName = addressBookDTO.firstName;
        this.lastName = addressBookDTO.lastName;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zip = addressBookDTO.zip;
        this.phoneNumber = addressBookDTO.phoneNumber;
        this.email = addressBookDTO.email;
    }
}