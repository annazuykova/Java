package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class Service {
    public static void serialize(File file, House house) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(house);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static House deserialize(File file)  {
        House house = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            house = (House) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return house;
    }

    public static String serializeJackson(House house) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(house);
    }

    public static House deserializeJackson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, House.class);
    }
}
