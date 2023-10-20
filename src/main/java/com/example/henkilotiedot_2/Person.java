package com.example.henkilotiedot_2;

import java.time.LocalDate;
import java.util.Date;

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

    public String toString() {
        return "";
    }

}
