package com.bridgelabz.addressbookappdevelopmentapplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AddressBookDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Person firstname Invalid it should be start with capital letter")
    @NotEmpty(message = "Person Name can't be null")
    public String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Person lastname Invalid it should be start with capital letter")
    @NotEmpty(message = "Person Name can't be null")
    public String lastName;

    @NotBlank(message = "address can not be empty")
    public String address;
    @NotBlank(message = "city can not be empty")

    public String city;
    @NotBlank(message = "state can not be empty")

    public String state;
    @NotBlank(message = "zip can not be empty")

    public int zip;
    @NotNull(message = "phoneNumber can not be empty")
    @JsonFormat(pattern = "^((\\\\+|00)(\\\\d{1,3})[\\\\s-]?)?(\\\\d{10})$")
    public String phoneNumber;
    @NotBlank(message = "email can not be empty")

    public String email;
}