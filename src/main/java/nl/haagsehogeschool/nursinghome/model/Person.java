package nl.haagsehogeschool.nursinghome.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class Person {
    private String firstName;
    private String surName;
    private String gender;
    private LocalDate birthDate;

    Person(String firstName, String surName, String gender, LocalDate birthDate) {
        this.firstName = firstName;
        this.surName = surName;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public abstract String getName();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public long getAge() {
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }
}
