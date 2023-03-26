package com.onlineLibrary.library.service;

import com.onlineLibrary.library.dto.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto savePerson(PersonDto personDto);
    void deletePerson(Integer loginID);
    PersonDto findByLogin(Integer loginID);
    List<PersonDto> findAll();
}
