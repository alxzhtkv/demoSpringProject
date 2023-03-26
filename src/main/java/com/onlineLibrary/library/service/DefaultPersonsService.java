package com.onlineLibrary.library.service;

import com.onlineLibrary.library.dto.PersonDto;


import static java.util.Objects.isNull;


import com.onlineLibrary.library.entity.Person;
import com.onlineLibrary.library.exception.ValidationException;
import com.onlineLibrary.library.repository.PersonsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DefaultPersonsService implements PersonService {
    private final PersonsRepository personsRepository;
    private final PersonConverter personConverter;

    private void validatePersonDto(PersonDto personDto) throws ValidationException {
        if (isNull(personDto)) {
            throw new ValidationException("Object person is null");
        }
        if (isNull(personDto.getLoginID()) || personDto.getLoginID().toString().isEmpty()) { //???
            throw new ValidationException("LoginID is empty");
        }
    }

    @Override
    public PersonDto savePerson(PersonDto personDto) {
//            throws ValidationException{
//        validatePersonDto(personDto);
        Person savedPerson = personsRepository.save(personConverter.fromPersonDtoToPerson(personDto));
        return  personConverter.fromPersonToPersonDto(savedPerson);
    }

    @Override
    public void deletePerson(Integer personID){
        personsRepository.deleteById(personID);
    }

    @Override
    public PersonDto findByLogin(Integer loginID){
        Person person = personsRepository.findByLoginID(loginID);
        if(person!=null){
            return personConverter.fromPersonToPersonDto(person);
        }
        return null;
    }
    @Override
    public List<PersonDto> findAll() {
        return personsRepository.findAll()
                .stream()
                .map(personConverter::fromPersonToPersonDto)
                .collect(Collectors.toList());
    }





}
