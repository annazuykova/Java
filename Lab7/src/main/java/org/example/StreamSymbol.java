package org.example;

import java.io.*;

public class StreamSymbol {
    public static void arrayToStreamSymbol(int[] arr, File file) {
        try (FileWriter stream = new FileWriter(file)) {
            for (int i : arr) {
                stream.write(i + " ");
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }

    public static int[] getArrayFromStreamSymbol(File file, int n) {
        int[] res = new int[n];
        try (BufferedReader stream = new BufferedReader(new FileReader(file))) {
            String line = stream.readLine();
            String[] arr = line.split(" ");
            for (int i = 0; i < n; i++) {
                res[i] = Integer.parseInt(arr[i]);
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
        return res;
    }

    public static int[] readArray(File file, int n, int pos) { // доделать!!!
        int[] res = new int[n-pos];
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            raf.seek(pos);
            String line = raf.readLine();
            String[] arr = line.split(" ");
            for (int i = 0; i < n-pos; i++) {
                res[i] = Integer.parseInt(arr[i]);
            }

        } catch (IOException e) {
            System.out.println("Ошибка");
        }
        return res;
    }

}
