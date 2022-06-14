package com.bridgelabz.addressbookappdevelopmentapplication.controller;

import com.bridgelabz.addressbookappdevelopmentapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookappdevelopmentapplication.dto.ResponseDTO;
import com.bridgelabz.addressbookappdevelopmentapplication.model.AddressBookData;
import com.bridgelabz.addressbookappdevelopmentapplication.service.IAddressBookService;
import com.bridgelabz.addressbookappdevelopmentapplication.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/addressbook")
@Slf4j
public class AddressBookController {
    @Autowired
    private IAddressBookService iAddressBookService;

    @Autowired
    private TokenUtil tokenUtil;
    @GetMapping("/get/all")
    public List<AddressBookData> getAddressBookData() {
        List<AddressBookData> addressBookDataList = iAddressBookService.getAddressBookData();
        return addressBookDataList;
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@RequestHeader String token) {
        AddressBookData addressBookData = iAddressBookService.getAddressBookDataById(token);
        ResponseDTO respDTO = new ResponseDTO("Get Call Success for id:", addressBookData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddressBookData(
            @Valid @RequestBody AddressBookDTO addressBookDTO) {
        log.debug("Person DTO" + addressBookDTO.toString());
        AddressBookData addressBookData = iAddressBookService.createAddressBookData(addressBookDTO);
        String token = tokenUtil.createToken(addressBookData.getPersonId());
        ResponseDTO respDTO = new ResponseDTO("Created Person data for:",token);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@RequestHeader String token,
                                                                 @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = iAddressBookService.updateAddressBookData(token, addressBookDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Person Data for: ", addressBookData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@RequestHeader String token) {
        iAddressBookService.deleteAddressBookData(token);
        ResponseDTO respDTO = new ResponseDTO("Delete Call Success for id: ", "PersonId " + tokenUtil.decodeToken(token));
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{firstName}")
    public ResponseEntity<ResponseDTO> sortPersonByName(@RequestHeader String firstName) {
        AddressBookData addressBookData = null;
        addressBookData = (AddressBookData) iAddressBookService.sortPersonByName(firstName);
        ResponseDTO respDTO = new ResponseDTO("Get Call for search by person Name Successful:", addressBookData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{city}")
    public ResponseEntity<ResponseDTO> sortPersonByCity(@PathVariable String city) {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = iAddressBookService.sortPersonByCity(city);
        ResponseDTO response = new ResponseDTO("Get Call for city Successful", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
    @GetMapping("/get/{state}")
    public ResponseEntity<ResponseDTO> sortPersonByState(@PathVariable String state) {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = iAddressBookService.sortPersonByState(state);
        ResponseDTO response = new ResponseDTO("Get Call for state Successful", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<ResponseDTO> deleteallPersonData() {
        String personData = iAddressBookService.deleteallPersonData();
        ResponseDTO respDTO = new ResponseDTO("Deleted Successful,Deleted Id:", personData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

}
