package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private String lastName;
    private String firstName;
    private String otchestvo;
    private int date;
    private int month;
    private int year;

    public Person() {
        lastName = "";
        firstName = "";
        otchestvo = "";
        date = 0;
        month = 0;
        year = 0;
    }

    public Person(String lastName, String firstName, String otchestvo, int date, int month, int year) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.otchestvo = otchestvo;
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDate() {
        return date;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return date == person.date && month == person.month && year == person.year && Objects.equals(lastName, person.lastName) && Objects.equals(firstName, person.firstName) && Objects.equals(otchestvo, person.otchestvo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, otchestvo, date, month, year);
    }

    @Override
    public String toString() {
        StringBuilder str =new StringBuilder("Person{ lastName = ");
        str.append(lastName);
        str.append(", firstName = ");
        str.append(firstName);
        str.append(", otchestvo = ");
        str.append(otchestvo);
        str.append(", date = ");
        str.append(date);
        str.append(", month = ");
        str.append(month);
        str.append(", year = ");
        str.append(year);
        str.append(" }");
        return str.toString();
    }
}
