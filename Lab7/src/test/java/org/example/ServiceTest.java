package org.example;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ServiceTest {

    @Test
    public void serialize() throws IOException {
        Person pers1 = new Person("Kotick", "Marina", "Timurovna", 23, 03, 1990);
        Person pers2 = new Person("Petunya", "Megera", "Horrorovna", 31, 11, 1970);
        Person pers3 = new Person("Polny", "Nikolya", "Renatovich", 22, 12, 2000);
        Person pers4 = new Person("Ivanov", "Ivan", "Ivanovich", 23, 11, 1980);
        Flat flat1 = new Flat(12, 80, Arrays.asList(pers1, pers3));
        Flat flat2 = new Flat(13, 66, Arrays.asList(pers2));
        Flat flat3 = new Flat(11, 40, Arrays.asList(pers4));
        House house = new House("123a", "Lermontova,20", pers4, Arrays.asList(flat1, flat2, flat3));
        File file = new File("Serialize.txt");
        Service.serialize(file, house);
        assertEquals(house, Service.deserialize(file));
        file.delete();
    }

    @Test
    public void deserialize() throws IOException {
        Person pers1 = new Person("Kotick", "Marina", "Timurovna", 23, 03, 1990);
        Person pers2 = new Person("Petunya", "Megera", "Horrorovna", 31, 11, 1970);
        Person pers3 = new Person("Polny", "Nikolya", "Renatovich", 22, 12, 2000);
        Flat flat1 = new Flat(12, 80, Arrays.asList(pers1, pers3));
        Flat flat2 = new Flat(13, 66, Arrays.asList(pers2));
        House house = new House("123a", "Lermontova,20", pers1, Arrays.asList(flat1, flat2));
        File file = new File("Serialize.txt");
        Service.serialize(file, house);
        assertEquals(house, Service.deserialize(file));
        file.delete();
    }
    @Test
    public void deserializeOne() throws IOException{
        Person pers1 = new Person();
        Person pers3 = new Person();
        Flat flat1 = new Flat(12, 80, Arrays.asList(pers1, pers3));
        House house = new House("12", "", pers1, Arrays.asList(flat1));
        File file = new File("Serialize.txt");
        Service.serialize(file, house);
        assertEquals(house, Service.deserialize(file));
        file.delete();
    }

    @Test
    public void serializeJackson() throws IOException {
        Person pers1 = new Person("Kotick", "Marina", "Timurovna", 23, 03, 1990);
        Person pers2 = new Person("Petunya", "Megera", "Horrorovna", 31, 11, 1970);
        Person pers3 = new Person("Polny", "Nikolya", "Renatovich", 22, 12, 2000);
        Person pers4 = new Person("Ivanov", "Ivan", "Ivanovich", 23, 11, 1980);
        Flat flat1 = new Flat(12, 80, Arrays.asList(pers1, pers3));
        Flat flat2 = new Flat(13, 66, Arrays.asList(pers2));
        Flat flat3 = new Flat(11, 40, Arrays.asList(pers4));
        House house = new House("123a", "Lermontova,20", pers4, Arrays.asList(flat1, flat2, flat3));
        System.out.println(Service.serializeJackson(house));
    }

    @Test
    public void deserializeJackson() throws IOException {
        Person pers1 = new Person("Kotick", "Marina", "Timurovna", 23, 03, 1990);
        Person pers2 = new Person("Petunya", "Megera", "Horrorovna", 31, 11, 1970);
        Person pers3 = new Person("Polny", "Nikolya", "Renatovich", 22, 12, 2000);
        Person pers4 = new Person("Ivanov", "Ivan", "Ivanovich", 23, 11, 1980);
        Flat flat1 = new Flat(12, 80, Arrays.asList(pers1, pers3));
        Flat flat2 = new Flat(13, 66, Arrays.asList(pers2));
        Flat flat3 = new Flat(11, 40, Arrays.asList(pers4));
        House house = new House("123a", "Lermontova,20", pers4, Arrays.asList(flat1, flat2, flat3));
        assertEquals(house,Service.deserializeJackson(Service.serializeJackson(house)));
    }
}