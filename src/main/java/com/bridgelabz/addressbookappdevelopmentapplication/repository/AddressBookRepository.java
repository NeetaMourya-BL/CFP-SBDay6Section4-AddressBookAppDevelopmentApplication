package com.bridgelabz.addressbookappdevelopmentapplication.repository;

import com.bridgelabz.addressbookappdevelopmentapplication.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {
    @Query(value = "select * from addressbook_db,addressbooktype where person_id=id and addressbook= :addressbook", nativeQuery = true)
    List<AddressBookData> findPersonByType(String addressbook);

}