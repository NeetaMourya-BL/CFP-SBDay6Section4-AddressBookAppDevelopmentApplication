package com.bridgelabz.addressbookappdevelopmentapplication.service;

import java.util.List;

import com.bridgelabz.addressbookappdevelopmentapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookappdevelopmentapplication.exception.AddressBookException;
import com.bridgelabz.addressbookappdevelopmentapplication.model.AddressBookData;
import com.bridgelabz.addressbookappdevelopmentapplication.repository.AddressBookRepository;
import com.bridgelabz.addressbookappdevelopmentapplication.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {
    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBookData getAddressBookDataById(String token) {

        return addressBookRepository.findById((int) tokenUtil.decodeToken(token))
                .orElseThrow(() -> new AddressBookException("Employee With employeeId: " + tokenUtil.decodeToken(token) + " does not exists"));
    }
    @Override
    public AddressBookData createAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData personData = new AddressBookData(addressBookDTO);
        return addressBookRepository.save(personData);
    }

    @Override
    public AddressBookData updateAddressBookData(@RequestHeader String token, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData personData = this.getAddressBookDataById(token);
        personData.updateAddressData(addressBookDTO);
        return addressBookRepository.save(personData);
    }

    @Override
    public void deleteAddressBookData(String token) {
        AddressBookData personData = this.getAddressBookDataById(token);
        addressBookRepository.delete(personData);
    }

    @Override
    public List<AddressBookData> sortPersonByName(String firstName) {
        return addressBookRepository.sortPersonByName(firstName);
    }

    @Override
    public List<AddressBookData> sortPersonByCity(String city) {
        return addressBookRepository.sortPersonByCity(city);
    }

    @Override
    public List<AddressBookData> sortPersonByState(String state) {
        return addressBookRepository.sortPersonByState(state);
    }

    @Override
    public String deleteallPersonData() {
        addressBookRepository.deleteAll();
        return "All Data Delete";
    }


}