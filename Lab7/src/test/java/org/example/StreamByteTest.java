package org.example;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class StreamByteTest {

    @Test
    public void arrayToStreamByteOne() {
        int[] arr = new int[10];
        File file1 = new File("DataByte.bin");
        for (int i = 0; i < 10; i++) {
            arr[i] += i;
        }
        StreamByte.arrayToStreamByte(arr, file1);
        int[] res = StreamByte.getArrayFromStreamByte(file1, 10);
        assertArrayEquals(arr, res);
        file1.delete();
    }

    @Test
    public void arrayToStreamByteTwo() {
        int[] arr = {12, 8, 3, 9, 0};
        File file1 = new File("DataByte.bin");
        StreamByte.arrayToStreamByte(arr, file1);
        int[] res = StreamByte.getArrayFromStreamByte(file1, 5);
        assertArrayEquals(arr, res);
        file1.delete();
    }

    @Test
    public void arrayToStreamByteThree() {
        int[] arr = {};
        File file1 = new File("DataByte.bin");
        StreamByte.arrayToStreamByte(arr, file1);
        int[] res = StreamByte.getArrayFromStreamByte(file1, 0);
        assertArrayEquals(arr, res);
        file1.delete();
    }

    @Test
    public void getArrayFromStreamByteOne() {
        int[] arr = {-1, 8, 63, -9, 15, 8};
        File file1 = new File("DataByte.bin");
        StreamByte.arrayToStreamByte(arr, file1);
        int[] res = StreamByte.getArrayFromStreamByte(file1, 6);
        assertArrayEquals(arr, res);
        file1.delete();
    }

    @Test
    public void getArrayFromStreamByteTwo() {
        int[] arr = {-1, -3, -6, 8};
        File file1 = new File("DataByte.bin");
        StreamByte.arrayToStreamByte(arr, file1);
        int[] res = StreamByte.getArrayFromStreamByte(file1, 4);
        assertArrayEquals(arr, res);
        file1.delete();
    }

}