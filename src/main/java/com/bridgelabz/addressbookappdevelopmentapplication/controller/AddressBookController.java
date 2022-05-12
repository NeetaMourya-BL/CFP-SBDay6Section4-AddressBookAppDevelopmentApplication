package com.bridgelabz.addressbookappdevelopmentapplication.controller;

import com.bridgelabz.addressbookappdevelopmentapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookappdevelopmentapplication.dto.ResponseDTO;
import com.bridgelabz.addressbookappdevelopmentapplication.model.AddressBookData;
import com.bridgelabz.addressbookappdevelopmentapplication.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
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
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("personId") int personId){
        AddressBookData addressBookData=null;
        addressBookData = iAddressBookService.getAddressBookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id:", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData=null;
        addressBookData = iAddressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create Employee payroll data for:", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update{personId}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("personId") int personId,@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData=null;
        addressBookData = iAddressBookService.updateAddressBookData(personId,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Employee payroll Data for: ", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressBookdata(@PathVariable("personId") int personId){
        iAddressBookService.deleteAddressBookData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Delete Call Success for id: ", "personId "+personId);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

}
