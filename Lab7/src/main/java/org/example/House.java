package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class House implements Serializable {
    private String numberHouse;
    private String address;
    private Person mainPerson;
    private List<Flat> flats;


    public House() {
        numberHouse = "";
        address = "";
        mainPerson = new Person();
        flats = new ArrayList<>();
    }

    public House(String numberHouse, String address, Person main, List<Flat> flats) {
        this.numberHouse = numberHouse;
        this.address = address;
        this.mainPerson = main;
        this.flats = flats;
    }

    public String getNumberHouse() {
        return numberHouse;
    }

    public String getAddress() {
        return address;
    }

    public Person getMainPerson() {
        return mainPerson;
    }

    public List<Flat> getFlats() {
        return flats;
    }


    @Override
    public int hashCode() {
        return Objects.hash(numberHouse, address, mainPerson, flats);
    }

    @Override
    public String toString() {
        return "House{" +
                "numberHouse='" + numberHouse + '\'' +
                ", address='" + address + '\'' +
                ", mainPerson=" + mainPerson +
                ", flats=" + flats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(numberHouse, house.numberHouse) && Objects.equals(address, house.address) && Objects.equals(mainPerson, house.mainPerson) && Objects.equals(flats, house.flats);
    }
}
