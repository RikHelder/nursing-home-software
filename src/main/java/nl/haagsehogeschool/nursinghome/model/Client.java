package nl.haagsehogeschool.nursinghome.model;

import java.time.LocalDate;

public class Client extends Person {
    private String medication;
    private String illnesses;
    private String handicaps;
    private boolean allowedToLeave;

    public Client(String firstName, String surName, String gender, LocalDate birthDate, String medication, String illnesses, String handicaps, boolean allowedToLeave) {
        super(firstName, surName, gender, birthDate);

        this.medication = medication;
        this.illnesses = illnesses;
        this.handicaps = handicaps;
        this.allowedToLeave = allowedToLeave;
    }

    @Override
    public String getName() {
        return getGender() + " " + getSurName();
    }

    public String getMedication() {
        return medication;
    }

    public String getIllnesses() {
        return illnesses;
    }

    public String getHandicaps() {
        return handicaps;
    }

    public boolean getAllowedToLeave() {
        return allowedToLeave;
    }

    @Override
    public String toString() {
        return getName();
    }
}
