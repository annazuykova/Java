package org.example;

import java.io.*;

public class StreamSymbol {
    public static void arrayToStreamSymbol(int[] arr, String file) throws IOException {
        try (FileWriter stream = new FileWriter(file)) {
            for (int i : arr) {
                stream.write(i + " ");
            }
        } catch (IOException e) {
            throw new IOException("Ошибка в работе с потоком");
        }
    }

    public static int[] getArrayFromStreamSymbol(String file, int n) throws IOException {
        if (n < 0) throw new IllegalArgumentException("n некорректный");
        int[] res = new int[n];
        try (BufferedReader stream = new BufferedReader(new FileReader(file))) {
            String line = stream.readLine();
            String[] arr = line.split(" ");
            for (int i = 0; i < n; i++) {
                res[i] = Integer.parseInt(arr[i]);
            }
        } catch (IOException e) {
            throw new IOException("Ошибка в работе с потоком");
        }
        return res;
    }

    public static int[] readArray(String file, int n, int pos) throws IOException {
        if (n < 0) throw new IllegalArgumentException("n некорректный");
        if (pos < 0) throw new IllegalArgumentException("pos некорректный");
        int[] res = new int[n - pos];
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            raf.seek(pos + 1);
            String line = raf.readLine();
            String[] arr = line.split(" ");
            for (int i = 0; i < n - pos; i++) {
                res[i] = Integer.parseInt(arr[i]);
            }
        } catch (IOException e) {
            throw new IOException("Ошибка в работе с потоком");
        }
        return res;
    }

    public static File[] getListOfFile(String dir, String ext) {
        class Filter implements FilenameFilter {
            private String extension;

            public Filter(String extension) {
                this.extension = extension;
            }

            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(extension);
            }
        }
        File file = new File(dir);
        File[] listFiles = file.listFiles(new Filter(ext));

        return listFiles;
    }

}
