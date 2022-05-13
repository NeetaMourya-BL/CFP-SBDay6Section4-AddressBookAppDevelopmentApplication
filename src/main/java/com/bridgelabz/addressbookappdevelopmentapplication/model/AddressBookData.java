package com.bridgelabz.addressbookappdevelopmentapplication.model;

import com.bridgelabz.addressbookappdevelopmentapplication.dto.AddressBookDTO;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "addressbook_db")
public @Data class AddressBookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personId", nullable = false)
    private int personId;
    @Column(name = "firstName")
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phoneNumber;
    private String email;
    @ElementCollection
    @CollectionTable(name = "addressbooktype", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "addressbook")
    private List<String> addressbook;

    public AddressBookData(AddressBookDTO addressBookDTO) {
        this.updatePersonAddressData(addressBookDTO);
    }

    public AddressBookData() {

    }

    public AddressBookData(int i, AddressBookDTO addressBookDTO) {

    }

    public void updatePersonAddressData( AddressBookDTO addressBookDTO) {
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