package com.onlineLibrary.library.repository;

import com.onlineLibrary.library.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsRepository extends JpaRepository<Person, Integer> {
    Person findByLoginID(Integer loginID);

}
