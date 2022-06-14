package com.bridgelabz.addressbookappdevelopmentapplication.repository;

import com.bridgelabz.addressbookappdevelopmentapplication.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {

    @Query(value = "select * from addressbook_db order by firstName", nativeQuery = true)
    List<AddressBookData> sortPersonByName(String firstName);
    @Query(value = "select * from addressbook_db order by city", nativeQuery = true)
    List<AddressBookData> sortPersonByCity(String city);

    @Query(value = "select * from addressbook_db order by state ", nativeQuery = true)
    List<AddressBookData> sortPersonByState(String state);

}