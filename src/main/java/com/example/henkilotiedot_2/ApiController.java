package com.example.henkilotiedot_2;


import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void addPerson() {}

    @PutMapping
    public void updatePerson() {}
    @DeleteMapping("")
    public void deletePerson(String id) {}
}
