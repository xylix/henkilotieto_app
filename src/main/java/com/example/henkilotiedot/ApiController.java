package com.example.henkilotiedot;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
public class ApiController {
    private final PersonService personService;

    public ApiController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public Collection<Person> persons() {
        return this.personService.getPersons();
    }

    @GetMapping("/persons/{id}")
    public Person person(@PathVariable String id) {
        if (!this.personService.exists(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Person not found"
            );
        }
        return this.personService.getPerson(id);
    }

    @PostMapping("/persons")
    public void addPerson(@RequestBody Person p) {
        if (this.personService.exists(p.id)) {
            throw new ResponseStatusException(
                    // CONFLICT is rarely used, sometimes 400 would be clearer
                    HttpStatus.CONFLICT, "Person already exists"
            );
        }
        this.personService.addPerson(p);

    }

    @PutMapping("/persons")
    public void updatePerson(@RequestBody Person p) {
        if (!this.personService.exists(p.id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Person to modify not found"
            );
        }
        this.personService.updatePerson(p);
    }
    @DeleteMapping("/persons")
    public void deletePerson(String id) {
        if (!this.personService.exists(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Person to delete not found"
            );
        }
        this.personService.delete(id);
    }
}
