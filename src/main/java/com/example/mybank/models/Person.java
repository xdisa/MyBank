package com.example.mybank.models;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
public class Person {


    private int id;

    private String lastName;

    private String firstName;

    private String patronymic;

    private HashMap<Integer, Double> accs;

    private int pin;

    public Person() {
    }

    public Person(int id, String lastName, String firstName, String patronymic, HashMap<Integer, Double> accs, int pin) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.accs = accs;
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "models.Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", accs=" + accs +
                ", pin=" + pin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return pin == person.pin && Objects.equals(lastName, person.lastName) && Objects.equals(firstName, person.firstName) && Objects.equals(patronymic, person.patronymic) && Objects.equals(accs, person.accs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, patronymic, accs, pin);
    }
}
