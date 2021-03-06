package com.bridgelabz.addressbookappdevelopmentapplication.service;
import com.bridgelabz.addressbookappdevelopmentapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookappdevelopmentapplication.model.AddressBookData;

import java.util.List;
public interface IAddressBookService {

    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookDataById(String token);

    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookData(String token,AddressBookDTO addressBookDTO);

    void deleteAddressBookData(String token);
    String deleteallPersonData();

    List<AddressBookData> sortPersonByName(String firstName);

    List<AddressBookData> sortPersonByCity(String city);
    List<AddressBookData> sortPersonByState(String state);
}
