package com.example.henkilotiedot_2;


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
    public String persons() {
        StringBuilder output = new StringBuilder();
        Collection<Person> persons = this.personService.getPersons();
        persons.forEach(output::append);
        return output.toString();
    }

    @GetMapping("/persons/{id}")
    public Person person(@PathVariable String id) {
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
    public void deletePerson(String id) {}
}
