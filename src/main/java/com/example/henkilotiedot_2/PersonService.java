package com.example.henkilotiedot_2;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

// Using a Service seemed simpler solution for this assignment than using beans.
// Beans could be the more extensible solution.
@Service
public class PersonService {
    private final HashMap<String, Person> persons = new HashMap<>();

    public Person getPerson(String id) {
        return this.persons.get(id);
    }

    public void addPerson(Person person) {
        this.persons.put(person.id, person);
    }

    public Collection<Person> getPersons() {
        return this.persons.values();
    }
}
