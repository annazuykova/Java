import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PaymentTest {

    Payment one = new Payment("Иванов Иван Иванович", 5, 8, 2023, 39001);
    Payment two = new Payment("Иванов Иван Иванович", 5, 8, 2023, 39001);
    Payment three = new Payment();
    int[] arr = new int[2];


    @Test
    public void testEquals() {
        assertTrue(one.equals(two));
        assertTrue(one.equals(one));
        assertFalse(three.equals(two));
        assertFalse(two.equals(three));
        assertFalse(three.equals(arr));
        two.setMonth(10);
        assertFalse(one.equals(two));
        assertFalse(three.equals(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(two.hashCode(), two.hashCode());
        assertEquals(Objects.hashCode(two), two.hashCode());
        assertEquals(Objects.hashCode(three), three.hashCode());
        assertTrue(one.hashCode() == two.hashCode());
    }

    @Test
    public void testToString() {
        assertTrue(one.toString().equals(two.toString()));
        assertEquals("Плательщик: , дата: 0.0.0, сумма: 0 руб. 0 коп.", three.toString());
        one.setDay(0);
        one.setMonth(0);
        one.setYear(0);
        assertEquals("Плательщик: Иванов Иван Иванович, дата: 0.0.0, сумма: 390 руб. 1 коп.", one.toString());
    }
}