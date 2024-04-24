package org.example;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class StreamByteTest {

    @Test
    public void arrayToStreamByteOne() throws IOException{
        int[] arr = new int[10];
        File file1 = new File("DataByte.bin");
        for (int i = 0; i < 10; i++) {
            arr[i] += i;
        }
        StreamByte.arrayToStreamByte(arr, "DataByte.bin");
        int[] res = StreamByte.getArrayFromStreamByte("DataByte.bin", 10);
        assertArrayEquals(arr, res);
        file1.delete();
    }

    @Test
    public void arrayToStreamByteTwo() throws IOException{
        int[] arr = {12, 8, 3, 9, 0};
        File file1 = new File("DataByte.bin");
        StreamByte.arrayToStreamByte(arr, "DataByte.bin");
        int[] res = StreamByte.getArrayFromStreamByte("DataByte.bin", 5);
        assertArrayEquals(arr, res);
        file1.delete();
    }

    @Test
    public void arrayToStreamByteThree() throws IOException{
        int[] arr = {};
        File file1 = new File("DataByte.bin");
        StreamByte.arrayToStreamByte(arr, "DataByte.bin");
        int[] res = StreamByte.getArrayFromStreamByte("DataByte.bin", 0);
        assertArrayEquals(arr, res);
        file1.delete();
    }

    @Test
    public void getArrayFromStreamByteOne() throws IOException {
        int[] arr = {-1, 8, 63, -9, 15, 8};
        File file1 = new File("DataByte.bin");
        StreamByte.arrayToStreamByte(arr, "DataByte.bin");
        int[] res = StreamByte.getArrayFromStreamByte("DataByte.bin", 6);
        assertArrayEquals(arr, res);
        file1.delete();
    }

    @Test
    public void getArrayFromStreamByteTwo() throws IOException{
        int[] arr = {-1, -3, -6, 8};
        File file1 = new File("DataByte.bin");
        StreamByte.arrayToStreamByte(arr, "DataByte.bin");
        int[] res = StreamByte.getArrayFromStreamByte("DataByte.bin", 4);
        assertArrayEquals(arr, res);
        file1.delete();
    }

}