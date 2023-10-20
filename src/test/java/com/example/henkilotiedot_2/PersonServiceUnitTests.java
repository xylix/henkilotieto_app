package com.example.henkilotiedot_2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class PersonServiceUnitTests {
    PersonService personService;
    // This could be a BeforeAll but then we would need to set up the test class lifecycle
    @BeforeEach
    public void setUp() {
        this.personService = new PersonService();
    }
    static Person createTestPerson() {
        LocalDate birth = LocalDate.of(1980, 10, 10);
        LocalDate death = null;
        Person p = new Person(
                "M Meikäläinen",
                "101010-000",
                "Testitie 1",
                "Finnish",
                "Suomi",
                "Spouse",
                birth,
                death);
        return p;
    }

    @Test
    void getPerson() {
        Person p = createTestPerson();
        this.personService.addPerson(p);
        Person p2 = this.personService.getPerson("101010-000");
        Assertions.assertEquals(p, p2);
    }
}
