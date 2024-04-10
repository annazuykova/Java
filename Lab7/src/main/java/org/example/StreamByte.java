package org.example;

import java.io.*;

public class StreamByte {

    public static void arrayToStreamByte(int[] arr, File file) {
        try (OutputStream stream = new FileOutputStream(file)) {
            for (int i : arr) {
                stream.write(i);
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }

    public static int[] getArrayFromStreamByte(File file, int n) {
        int[] arr = new int[n];
        try (InputStream stream = new FileInputStream(file)) {
            for (int i = 0; stream.available() > 0; i++) {
                arr[i] = stream.read();
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
        return arr;
    }

}
