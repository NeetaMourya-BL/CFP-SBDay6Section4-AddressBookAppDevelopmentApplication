package com.bridgelabz.addressbookappdevelopmentapplication.service;

import java.util.ArrayList;
import java.util.List;
import com.bridgelabz.addressbookappdevelopmentapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookappdevelopmentapplication.exception.AddressBookException;
import com.bridgelabz.addressbookappdevelopmentapplication.model.AddressBookData;
import com.bridgelabz.addressbookappdevelopmentapplication.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {
    @Autowired
    private AddressBookRepository addressBookRepository;
    private List <AddressBookData> addressBookDataList = new ArrayList<>();
    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookRepository.findAll();
    }
    @Override
    public AddressBookData getAddressBookDataById(int personId) throws Exception {
        return addressBookRepository.findById(personId)
                .orElseThrow(() -> new AddressBookException("Employee Not found with the id:" +personId + "Doesn't Exists...!"));    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData personData = null;
        personData = new AddressBookData(addressBookDataList.size()+1,addressBookDTO);
        log.debug("Person Data:" + personData.toString());
        return addressBookRepository.save(personData);
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO) throws Exception {
        AddressBookData personData = this.getAddressBookDataById(personId);
        personData.updatePersonAddressData(addressBookDTO);
        return addressBookRepository.save(personData);
    }

    @Override
    public void deleteAddressBookData(int personId) throws Exception {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        addressBookRepository.delete(addressBookData);
    }

    @Override
    public List<AddressBookData> getPersonDataByType(String addressbook) {
        return addressBookRepository.findPersonByType(addressbook);
    }

}