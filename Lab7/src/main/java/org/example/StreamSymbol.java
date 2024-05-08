package org.example;

import java.io.*;

public class StreamSymbol {
    public static void arrayToStreamSymbol(int[] arr, String file) {
        try (FileWriter stream = new FileWriter(file)) {
            for (int i : arr) {
                stream.write(i + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] getArrayFromStreamSymbol(String file, int n) {
        if (n < 0) throw new IllegalArgumentException("n некорректный");
        int[] res = new int[n];
        try (BufferedReader stream = new BufferedReader(new FileReader(file))) {
            String line = stream.readLine();
            String[] arr = line.split(" ");
            for (int i = 0; i < n; i++) {
                res[i] = Integer.parseInt(arr[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static int[] readArray(String file, int n, int pos) {
        if (n < 0) throw new IllegalArgumentException("n некорректный");
        if (pos < 0) throw new IllegalArgumentException("pos некорректный");
        int[] res = new int[n - pos];
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            raf.seek(pos * 4L);
            for (int i = 0; i < n - pos; i++) {
                res[i] = raf.readInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static File[] getListOfFile(String dir, String extension) {
        File[] listFiles;
        File directory = new File(dir);
        listFiles = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(extension);
            }
        });
        return listFiles;
    }

}
