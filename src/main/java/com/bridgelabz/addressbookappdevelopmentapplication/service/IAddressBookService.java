package com.bridgelabz.addressbookappdevelopmentapplication.service;
import com.bridgelabz.addressbookappdevelopmentapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookappdevelopmentapplication.model.AddressBookData;

import java.util.List;
public interface IAddressBookService {
    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookDataById(int personId) throws Exception;

    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookData(int personId,AddressBookDTO addressBookDTO) throws Exception;

    void deleteAddressBookData(int personId) throws Exception;
List<AddressBookData> getPersonDataByType(String addressbook);
}
