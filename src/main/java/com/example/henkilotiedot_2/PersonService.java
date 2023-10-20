package com.example.henkilotiedot_2;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

// Using a Service seemed simpler solution for this assignment than using beans.
// Beans could be the more extensible solution.
// Since we use the personal id number as the id of a person, it would cause some difficulty if a person does not
// have a finnish identity number or if their identity number changes.
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
        if (!this.persons.containsKey(person.id)) {
            throw new NullPointerException();
        }
        this.persons.put(person.id, person);
    }

    public Collection<Person> getPersons() {
        return this.persons.values();
    }

    public void delete(String id) {
        if (!this.persons.containsKey(id)) {
            throw new NullPointerException();
        }
        this.persons.remove(id);
    }
}
