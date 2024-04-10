package org.example;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class StreamSymbolTest {
    @Test
    public void arrayToStreamSymbolOne() {
        int[] arr = {1, -1, 3, 4, 5};
        File file1 = new File("DataSymbol.txt");
        StreamSymbol.arrayToStreamSymbol(arr, file1);
        int[] res = StreamSymbol.getArrayFromStreamSymbol(file1, 5);
        assertArrayEquals(arr, res);
        file1.delete();
    }

    @Test
    public void arrayToStreamSymbolTwo() {
        int[] arr = {45, 0, -200, 56, 77, 98};
        File file1 = new File("DataSymbol.txt");
        StreamSymbol.arrayToStreamSymbol(arr, file1);
        int[] res = StreamSymbol.getArrayFromStreamSymbol(file1, 6);
        assertArrayEquals(arr, res);
        file1.delete();
    }

    @Test
    public void arrayToStreamSymbolThree() {
        int[] arr = {-1};
        File file1 = new File("DataSymbol.txt");
        StreamSymbol.arrayToStreamSymbol(arr, file1);
        int[] res = StreamSymbol.getArrayFromStreamSymbol(file1, 1);
        assertArrayEquals(arr, res);
        file1.delete();
    }


    @Test
    public void getArrayFromStreamSymbolOne() {
        int[] arr = {-100000,0};
        File file1 = new File("DataSymbol.txt");
        StreamSymbol.arrayToStreamSymbol(arr, file1);
        int[] res = StreamSymbol.getArrayFromStreamSymbol(file1, 2);
        assertArrayEquals(arr, res);
        file1.delete();
    }

    @Test
    public void getArrayFromStreamSymbolTwo() {
        int[] arr = {1,2,3,4,5,6,7,8,9,-1};
        File file1 = new File("DataSymbol.txt");
        StreamSymbol.arrayToStreamSymbol(arr, file1);
        int[] res = StreamSymbol.getArrayFromStreamSymbol(file1, 10);
        assertArrayEquals(arr, res);
        file1.delete();

    }


    @Test
    public void readArray() {
        int[] arr = {1,2,3,4,5,6,7,8,9,-1};
        File file1 = new File("DataSymbol.txt");
        StreamSymbol.arrayToStreamSymbol(arr, file1);
        int[] res = StreamSymbol.readArray(file1, 10,1);
        assertArrayEquals(new int[]{2,3,4,5,6,7,8,9,-1}, res);
        file1.delete();
    }
}