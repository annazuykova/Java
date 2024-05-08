package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ServiceTest {

    @Test
    public void serializeTest(){
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
    }

    @Test
    public void deserializeTest() {
        Person pers1 = new Person("Kotick", "Marina", "Timurovna", 23, 03, 1990);
        Person pers2 = new Person("Petunya", "Megera", "Horrorovna", 31, 11, 1970);
        Person pers3 = new Person("Polny", "Nikolya", "Renatovich", 22, 12, 2000);
        Flat flat1 = new Flat(12, 80, Arrays.asList(pers1, pers3));
        Flat flat2 = new Flat(13, 66, Arrays.asList(pers2));
        House house = new House("123a", "Lermontova,20", pers1, Arrays.asList(flat1, flat2));
        File file = new File("Serialize.txt");
        Service.serialize(file, house);
        assertEquals(house, Service.deserialize(file));
    }

    @Test
    public void deserializeOne() {
        Person pers1 = new Person();
        Person pers3 = new Person();
        Flat flat1 = new Flat(12, 80, Arrays.asList(pers1, pers3));
        House house = new House("12", "", pers1, Arrays.asList(flat1));
        File file = new File("Serialize.txt");
        Service.serialize(file, house);
        assertEquals(house, Service.deserialize(file));
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
        String res = "{\"numberHouse\":\"123a\",\"address\":\"Lermontova,20\",\"mainPerson\":{\"lastName\":\"Ivanov\",\"firstName\":\"Ivan\",\"otchestvo\":\"Ivanovich\",\"date\":23,\"month\":11,\"year\":1980},\"flats\":[{\"number\":12,\"square\":80,\"people\":[{\"lastName\":\"Kotick\",\"firstName\":\"Marina\",\"otchestvo\":\"Timurovna\",\"date\":23,\"month\":3,\"year\":1990},{\"lastName\":\"Polny\",\"firstName\":\"Nikolya\",\"otchestvo\":\"Renatovich\",\"date\":22,\"month\":12,\"year\":2000}]},{\"number\":13,\"square\":66,\"people\":[{\"lastName\":\"Petunya\",\"firstName\":\"Megera\",\"otchestvo\":\"Horrorovna\",\"date\":31,\"month\":11,\"year\":1970}]},{\"number\":11,\"square\":40,\"people\":[{\"lastName\":\"Ivanov\",\"firstName\":\"Ivan\",\"otchestvo\":\"Ivanovich\",\"date\":23,\"month\":11,\"year\":1980}]}]}";
        assertEquals(res, Service.serializeJackson(house));
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
        String res = "{\"numberHouse\":\"123a\",\"address\":\"Lermontova,20\",\"mainPerson\":{\"lastName\":\"Ivanov\",\"firstName\":\"Ivan\",\"otchestvo\":\"Ivanovich\",\"date\":23,\"month\":11,\"year\":1980},\"flats\":[{\"number\":12,\"square\":80,\"people\":[{\"lastName\":\"Kotick\",\"firstName\":\"Marina\",\"otchestvo\":\"Timurovna\",\"date\":23,\"month\":3,\"year\":1990},{\"lastName\":\"Polny\",\"firstName\":\"Nikolya\",\"otchestvo\":\"Renatovich\",\"date\":22,\"month\":12,\"year\":2000}]},{\"number\":13,\"square\":66,\"people\":[{\"lastName\":\"Petunya\",\"firstName\":\"Megera\",\"otchestvo\":\"Horrorovna\",\"date\":31,\"month\":11,\"year\":1970}]},{\"number\":11,\"square\":40,\"people\":[{\"lastName\":\"Ivanov\",\"firstName\":\"Ivan\",\"otchestvo\":\"Ivanovich\",\"date\":23,\"month\":11,\"year\":1980}]}]}";
        assertEquals(house, Service.deserializeJackson(res));
    }
    @Test(expected = JsonProcessingException.class)
    public void JacksonException() throws JsonProcessingException {
        assertEquals(new House(), Service.deserializeJackson(" "));
    }

}