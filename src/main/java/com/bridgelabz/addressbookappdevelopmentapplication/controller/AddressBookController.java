package com.bridgelabz.addressbookappdevelopmentapplication.controller;

import com.bridgelabz.addressbookappdevelopmentapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookappdevelopmentapplication.dto.ResponseDTO;
import com.bridgelabz.addressbookappdevelopmentapplication.exception.AddressBookException;
import com.bridgelabz.addressbookappdevelopmentapplication.model.AddressBookData;
import com.bridgelabz.addressbookappdevelopmentapplication.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/addressbook")
@Slf4j
public class AddressBookController {
    @Autowired
    private IAddressBookService iAddressBookService;
    @RequestMapping(value= {"","/","get"})
    public ResponseEntity<ResponseDTO> getAddressBookData(){
        List<AddressBookData> addressBookDataList=null;
        addressBookDataList = iAddressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success",addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("personId") int personId) throws Exception {
        AddressBookData addressBookData=null;
        addressBookData = iAddressBookService.getAddressBookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id:", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO){
        log.debug("Person DTO" +addressBookDTO.toString());
        AddressBookData addressBookData=null;
        addressBookData = iAddressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create Address Book data for:", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update{personId}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("personId") int personId,@Valid @RequestBody AddressBookDTO addressBookDTO) throws Exception {
        AddressBookData addressBookData=null;
        addressBookData = iAddressBookService.updateAddressBookData(personId,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Address Book Data for: ", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressBookdata(@PathVariable("personId") int personId) throws Exception {
        iAddressBookService.deleteAddressBookData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Delete Call Success for id: ", "personId "+personId);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/addressbooktype/{addressbooktype}")
    public ResponseEntity<ResponseDTO> getPersonDataByType(@PathVariable String addressbooktype) {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = iAddressBookService.getPersonDataByType(addressbooktype);
        ResponseDTO response = new ResponseDTO("Get Call for address book type Successful", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

}
