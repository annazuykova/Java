package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flat implements Serializable {
    private int number;
    private int square;
    private List<Person> people;

    public Flat() {
        people = new ArrayList<>();
        number = 0;
        square = 0;
    }

    public Flat(int number, int square, List<Person> people) {
        this.number = number;
        this.square = square;
        this.people = people;
    }

    public int getNumber() {
        return number;
    }

    public int getSquare() {
        return square;
    }

    public List<Person> getPeople() {
        return people;
    }


    @Override
    public int hashCode() {
        return Objects.hash(number, square, people);
    }

    @Override
    public String toString() {
        return "Flat{" +
                "number=" + number +
                ", square=" + square +
                ", people=" + people +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return number == flat.number && square == flat.square && Objects.equals(people, flat.people);
    }
}
