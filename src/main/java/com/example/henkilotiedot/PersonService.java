package com.example.henkilotiedot;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

// Using a Service seemed simpler solution for this assignment than using beans.
// Beans could be the more extensible solution.
// Since we use the personal id number as the id of a person, it would cause some difficulty if a person does not
// have a finnish identity number or if their identity number changes.

// The service could have `id` checks, but since this is for a web api that will have to implement possible
// errors at the top level anyway, we just provide an `exists` method and trust the caller of the API to verify.
@Service
public class PersonService {
    private final HashMap<String, Person> persons = new HashMap<>();

    public Person getPerson(String id) {
        return this.persons.get(id);
    }

    public boolean exists(String id) {
        return this.persons.get(id) != null;
    }

    public void addPerson(Person person) {
        this.persons.put(person.id, person);
    }

    public void updatePerson(Person person) {
        this.persons.put(person.id, person);
    }

    public Collection<Person> getPersons() {
        return this.persons.values();
    }

    public void delete(String id) {
        this.persons.remove(id);
    }
}
