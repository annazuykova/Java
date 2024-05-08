package org.example;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class StreamSymbolTest {
    @Test
    public void arrayToStreamSymbolOne() {
        int[] arr = {1, -1, 3, 4, 5};
        StreamSymbol.arrayToStreamSymbol(arr, "DataSymbol.txt");
        int[] res = StreamSymbol.getArrayFromStreamSymbol("DataSymbol.txt", 5);
        assertArrayEquals(arr, res);
    }

    @Test
    public void arrayToStreamSymbolTwo() {
        int[] arr = {45, 0, -200, 56, 77, 98};
        StreamSymbol.arrayToStreamSymbol(arr, "DataSymbol.txt");
        int[] res = StreamSymbol.getArrayFromStreamSymbol("DataSymbol.txt", 6);
        assertArrayEquals(arr, res);
    }

    @Test
    public void arrayToStreamSymbolThree() {
        int[] arr = {-1};
        StreamSymbol.arrayToStreamSymbol(arr, "DataSymbol.txt");
        int[] res = StreamSymbol.getArrayFromStreamSymbol("DataSymbol.txt", 1);
        assertArrayEquals(arr, res);
    }


    @Test
    public void getArrayFromStreamSymbolOne() {
        int[] arr = {-100000, 0};
        StreamSymbol.arrayToStreamSymbol(arr, "DataSymbol.txt");
        int[] res = StreamSymbol.getArrayFromStreamSymbol("DataSymbol.txt", 2);
        assertArrayEquals(arr, res);
    }

    @Test
    public void getArrayFromStreamSymbolTwo() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, -1};
        StreamSymbol.arrayToStreamSymbol(arr, "DataSymbol.txt");
        int[] res = StreamSymbol.getArrayFromStreamSymbol("DataSymbol.txt", 10);
        assertArrayEquals(arr, res);

    }

    @Test
    public void readArrayOne() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, -1};
        StreamByte.arrayToStreamByte(arr, "DataSymbol.txt");
        int[] res = StreamSymbol.readArray("DataSymbol.txt", 10, 1);
        assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7, 8, 9, -1}, res);
    }

    @Test
    public void readArrayTwo() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, -1};
        StreamByte.arrayToStreamByte(arr, "DataSymbol.txt");
        int[] res = StreamSymbol.readArray("DataSymbol.txt", 10, 5);
        assertArrayEquals(new int[]{6, 7, 8, 9, -1}, res);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void readArrayThree() {
        int[] arr = {};
        StreamByte.arrayToStreamByte(arr, "DataSymbol.txt");
        int[] res = StreamSymbol.readArray("DataSymbol.txt", 0, 1);
        assertArrayEquals(new int[]{}, res);
    }

    @Test
    public void getListOfFileOne() {
        File[] res = StreamSymbol.getListOfFile("C:/Users/Анна/IdeaProjects/Java/Lab7/src/main/java/org/example/", ".java");
        File[] expected = new File[6];
        for (int i = 0; i < 6; i++) {
            expected[i] = res[i];
        }
        assertArrayEquals(expected, res);
    }

    @Test
    public void getListOfFileTwo() {
        File[] res = StreamSymbol.getListOfFile("C:/Users/Анна/IdeaProjects/Java/Lab7/src/test/java/org/example/", ".java");
        File[] expected = new File[3];
        for (int i = 0; i < 3; i++) {
            expected[i] = res[i];
        }
        assertArrayEquals(expected, res);
    }
}