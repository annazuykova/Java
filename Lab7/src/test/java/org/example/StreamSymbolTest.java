package org.example;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class StreamSymbolTest {
    @Test
    public void arrayToStreamSymbolOne() throws IOException {
        int[] arr = {1, -1, 3, 4, 5};
        File file1 = new File("DataSymbol.txt");
        StreamSymbol.arrayToStreamSymbol(arr, "DataSymbol.txt");
        int[] res = StreamSymbol.getArrayFromStreamSymbol("DataSymbol.txt", 5);
        assertArrayEquals(arr, res);
        file1.delete();
    }

    @Test
    public void arrayToStreamSymbolTwo() throws IOException {
        int[] arr = {45, 0, -200, 56, 77, 98};
        File file1 = new File("DataSymbol.txt");
        StreamSymbol.arrayToStreamSymbol(arr, "DataSymbol.txt");
        int[] res = StreamSymbol.getArrayFromStreamSymbol("DataSymbol.txt", 6);
        assertArrayEquals(arr, res);
        file1.delete();
    }

    @Test
    public void arrayToStreamSymbolThree() throws IOException {
        int[] arr = {-1};
        File file1 = new File("DataSymbol.txt");
        StreamSymbol.arrayToStreamSymbol(arr, "DataSymbol.txt");
        int[] res = StreamSymbol.getArrayFromStreamSymbol("DataSymbol.txt", 1);
        assertArrayEquals(arr, res);
        file1.delete();
    }


    @Test
    public void getArrayFromStreamSymbolOne() throws IOException {
        int[] arr = {-100000, 0};
        File file1 = new File("DataSymbol.txt");
        StreamSymbol.arrayToStreamSymbol(arr, "DataSymbol.txt");
        int[] res = StreamSymbol.getArrayFromStreamSymbol("DataSymbol.txt", 2);
        assertArrayEquals(arr, res);
        file1.delete();
    }

    @Test
    public void getArrayFromStreamSymbolTwo() throws IOException {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, -1};
        File file1 = new File("DataSymbol.txt");
        StreamSymbol.arrayToStreamSymbol(arr, "DataSymbol.txt");
        int[] res = StreamSymbol.getArrayFromStreamSymbol("DataSymbol.txt", 10);
        assertArrayEquals(arr, res);
        file1.delete();

    }


    @Test
    public void readArrayOne() throws IOException {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, -1};
        File file1 = new File("DataSymbol.txt");
        StreamSymbol.arrayToStreamSymbol(arr, "DataSymbol.txt");
        int[] res = StreamSymbol.readArray("DataSymbol.txt", 10, 1);
        assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7, 8, 9, -1}, res);
        file1.delete();
    }

    @Test(expected = NegativeArraySizeException.class)
    public void readArrayTwo() throws IOException {
        int[] arr = {};
        File file1 = new File("DataSymbol.txt");
        StreamSymbol.arrayToStreamSymbol(arr, "DataSymbol.txt");
        int[] res = StreamSymbol.readArray("DataSymbol.txt", 0, 1);
        assertArrayEquals(new int[]{}, res);
        file1.delete();
    }

    @Test
    public void getListOfFileOne() {
        File[] res = StreamSymbol.getListOfFile("C:/Users/Анна/IdeaProjects/Java/Lab7/src/main/java/org/example/", ".java");
        assertEquals(7, res.length);
    }
    @Test
    public void getListOfFileTwo() {
        File[] res = StreamSymbol.getListOfFile("C:/Users/Анна/IdeaProjects/Java/Lab7/src/test/java/org/example/", ".java");
        assertEquals(3, res.length);
    }
}