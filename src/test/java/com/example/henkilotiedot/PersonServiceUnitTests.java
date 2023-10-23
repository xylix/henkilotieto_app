package com.example.henkilotiedot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class PersonServiceUnitTests {
    PersonService personService;
    @BeforeEach
    public void setUp() {
        this.personService = new PersonService();
    }
    static Person createTestPerson(String name, String id) {
        LocalDate birth = LocalDate.of(1980, 10, 10);
        LocalDate death = null;
        return new Person(
                name,
                id,
                "Testitie 1",
                "Finnish",
                "Suomi",
                "Spouse",
                birth,
                death);
    }

    // Testing two methods in one test is a bad pattern, but we can't verify the creation without getting. And we can't
    // Verify the getting without addition.
    @Test
    void addAndGetPerson() {
        Person p = createTestPerson("M Meikäläinen", "101010-000");
        this.personService.addPerson(p);
        Person p2 = this.personService.getPerson("101010-000");
        Assertions.assertEquals(p.id, p2.id);
        Assertions.assertEquals(p, p2);
    }

    @Test
    void addTwoPersons() {
        Person p = createTestPerson("M Meikäläinen", "101010-000");
        Person p2 = createTestPerson("Testi Testihenkilö", "000000-000");
        this.personService.addPerson(p);
        this.personService.addPerson(p2);

        Assertions.assertEquals(p.name, this.personService.getPerson(p.id).name);
        Assertions.assertEquals(p2.name, this.personService.getPerson(p2.id).name);

    }

    @Test
    void updatePerson() {
        Person p = createTestPerson("M Meikäläinen", "101010-000");
        this.personService.addPerson(p);
        Assertions.assertEquals(p, this.personService.getPerson(p.id));
        Person updated = createTestPerson("A Meikäläinen", "101010-000");
        this.personService.updatePerson(updated);
        Assertions.assertEquals(updated, this.personService.getPerson(updated.id));
    }

    @Test
    void deletePerson() {
        Person p = createTestPerson("M Meikäläinen", "101010-000");
        this.personService.addPerson(p);
        Assertions.assertEquals(p, this.personService.getPerson(p.id));
        this.personService.delete(p.id);
        Assertions.assertNull(this.personService.getPerson(p.id));

    }
}
