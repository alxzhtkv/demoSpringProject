package com.onlineLibrary.library.controller;

import com.onlineLibrary.library.dto.PersonDto;
import com.onlineLibrary.library.exception.ValidationException;
import com.onlineLibrary.library.service.*;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
@AllArgsConstructor
@Log
public class PersonController {


    private final PersonService personService;

    @PostMapping("/save")
    public PersonDto saveUsers(@RequestBody PersonDto personDto) throws ValidationException {
        log.info("Handling save persons: " + personDto);
        return personService.savePerson(personDto);
    }

    @GetMapping("/findAll")
    public List<PersonDto> findAllUsers() {
        log.info("Handling find all persons request");
        return personService.findAll();
    }

    @GetMapping("/findByLogin")
    public PersonDto findByLogin(@RequestParam Integer login) {
        log.info("Handling find by login request: " + login);
        return personService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        log.info("Handling delete user request: " + id);
        personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }
}
