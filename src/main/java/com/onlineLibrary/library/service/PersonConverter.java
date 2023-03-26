package com.onlineLibrary.library.service;

import com.onlineLibrary.library.dto.PersonDto;
import com.onlineLibrary.library.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {

    public Person fromPersonDtoToPerson(PersonDto personDto) {
        Person person = new Person();
        person.setId(personDto.getId());
        person.setLoginID(personDto.getLoginID());
        person.setPassword(personDto.getPassword());
        person.setRole(personDto.getRole());
        return person;
    }
    public PersonDto fromPersonToPersonDto(Person person){
//        PersonDto personDto = new PersonDto();
//        personDto.setId(person.getId());
//        personDto.setLoginID(personDto.getLoginID());
//        personDto.setPassword(personDto.getPassword());
//        personDto.setRole(personDto.getRole());
//        return  personDto;
        return PersonDto.builder()
                .id(person.getId())
                .loginID(person.getLoginID())
                .password(person.getPassword())
                .role(person.getRole())
                .build();



    }

}
