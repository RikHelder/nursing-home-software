package nl.haagsehogeschool.nursinghome.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Visitor extends Person {
    private String code;

    public Visitor(String firstName, String surName, String gender, LocalDate birthDate, String code) {
        super(firstName, surName, gender, birthDate);

        this.code = code;
    }

    @Override
    public String getName() {
        return "(Visitor) " + getFirstName() + " " + getSurName();
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return getName();
    }
}
