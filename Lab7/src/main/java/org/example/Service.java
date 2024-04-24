package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class Service {
    public static void serialize(File file, House house) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(house);
        } catch (IOException e) {
            throw new IOException("Ошибка в работе с потоком");
        }
    }

    public static House deserialize(File file) throws IOException {
        House house = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            house = (House) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("Ошибка в работе с потоком");
        }
        return house;
    }

    public static String serializeJackson(House house) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(house);
        return jsonString;
    }

    public static House deserializeJackson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, House.class);
    }
}
