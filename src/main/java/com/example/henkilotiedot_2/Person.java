package com.example.henkilotiedot_2;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Person {
    public Person(String name, String id, String address, String nationality, String native_language, String family_information, LocalDate birth, LocalDate death) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.nationality = nationality;
        this.native_language = native_language;
        this.family_information = family_information;
        this.birth = birth;
        this.death = death;
    }

    String name;
    String id; // Henkilötunnus
    String address;
    String nationality;
    String native_language;
    String family_information;
    // LocalDate seems to be the modern type for dates, in Java 8 we could also use just plain Date
    LocalDate birth;
    LocalDate death;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(id, person.id) && Objects.equals(address, person.address) && Objects.equals(nationality, person.nationality) && Objects.equals(native_language, person.native_language) && Objects.equals(family_information, person.family_information) && Objects.equals(birth, person.birth) && Objects.equals(death, person.death);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, address, nationality, native_language, family_information, birth, death);
    }
}
