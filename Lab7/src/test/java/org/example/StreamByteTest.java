package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class StreamByteTest {

    @Test
    public void arrayToStreamByteOne() {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] += i;
        }
        StreamByte.arrayToStreamByte(arr, "DataByte.bin");
        int[] res = StreamByte.getArrayFromStreamByte("DataByte.bin", 10);
        assertArrayEquals(arr, res);
    }

    @Test
    public void arrayToStreamByteTwo(){
        int[] arr = {12, 8, 3, 9, 0};
        StreamByte.arrayToStreamByte(arr, "DataByte.bin");
        int[] res = StreamByte.getArrayFromStreamByte("DataByte.bin", 5);
        assertArrayEquals(arr, res);
    }

    @Test
    public void arrayToStreamByteThree() {
        int[] arr = {};
        StreamByte.arrayToStreamByte(arr, "DataByte.bin");
        int[] res = StreamByte.getArrayFromStreamByte("DataByte.bin", 0);
        assertArrayEquals(arr, res);
    }

    @Test
    public void getArrayFromStreamByteOne() {
        int[] arr = {-1, 8, 63, -9, 15, 8};
        StreamByte.arrayToStreamByte(arr, "DataByte.bin");
        int[] res = StreamByte.getArrayFromStreamByte("DataByte.bin", 6);
        assertArrayEquals(arr, res);
    }

    @Test
    public void getArrayFromStreamByteTwo() {
        int[] arr = {-1, -3, -6, 8};
        StreamByte.arrayToStreamByte(arr, "DataByte.bin");
        int[] res = StreamByte.getArrayFromStreamByte("DataByte.bin", 4);
        assertArrayEquals(arr, res);
    }

}