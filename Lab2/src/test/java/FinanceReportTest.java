import org.junit.Test;

import static org.junit.Assert.*;

public class FinanceReportTest {
    Payment[] arr = {new Payment("Иванов Иван Иванович", 5, 8, 2023, 39001),
            new Payment("Иванова Моника Карповна", 5, 8, 2023, 150000),
            new Payment("Иванов Иван Иванович", 9, 11, 2022, 555),
            new Payment("Куровский Иван Петрович", 25, 1, 2020, 6545683)};

    Payment[] tmp = {new Payment("Куратова Зоя Демьяновна", 7, 12, 2022, 3956001),
            new Payment("Котик София Анатольевна", 11, 8, 2022, 435600),
            new Payment("Тугарин Змей Горыныч", 28, 4, 2023, 55646455),
            new Payment("Богданов Богдан Богданович", 17, 1, 2021, 65453683)};
    FinanceReport one = new FinanceReport("Кристальная Катерина Андреевна", arr, 5, 11, 2023);
    FinanceReport two = new FinanceReport();
    FinanceReport three = new FinanceReport("Лукавый Дмитрий Генадьевич", tmp, 29, 2, 2023);
    FinanceReport copy = new FinanceReport(three);

    @Test
    public void countPayments() {
        assertEquals(0, two.countPayments());
        assertEquals(4, one.countPayments());
    }

    @Test
    public void testToString() {
        assertEquals(copy.toString(), three.toString());
    }

    @Test(expected = Exception.class)
    public void testFinanceReportCopy() {
        assertEquals(copy.toString(), three.toString());
        three.setPayment(0, new Payment("Иванов Иван Иванович", 5, 8, 2023, 39001));
        assertFalse(copy.toString().equals(three.toString()));
        FinanceReport copyTmp = new FinanceReport(null);
    }
}