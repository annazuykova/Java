package org.example;

import java.io.*;

public class StreamByte {

    public static void arrayToStreamByte(int[] arr, String file) throws IOException {
        try (DataOutputStream stream = new DataOutputStream(new FileOutputStream(file))) {
            for (int i : arr) {
                stream.writeInt(i);
            }
        } catch (IOException e) {
            throw new IOException("Ошибка в работе с потоком");
        }
    }

    public static int[] getArrayFromStreamByte(String file, int n) throws IOException {
        if (n < 0) throw new IllegalArgumentException("n некорректный");
        int[] arr = new int[n];
        try (DataInputStream stream = new DataInputStream(new FileInputStream(file))) {
            for (int i = 0; i < n; i++) {
                arr[i] = stream.readInt();
            }
        } catch (IOException e) {
            throw new IOException("Ошибка в работе с потоком");
        }
        return arr;
    }

}
