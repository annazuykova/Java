import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class FinanceReportProcessorTest {

    Payment[] arr = {new Payment("Иванов Иван Иванович", 5, 8, 2023, 39999),
            new Payment("Иванова Моника Карповна", 5, 8, 2023, 150000),
            new Payment("Иванов Иван Иванович", 9, 11, 2022, 555),
            new Payment("Куровский Иван Петрович", 25, 1, 2020, 40000)};
    Payment[] res1 = {new Payment("Иванов Иван Иванович", 5, 8, 2023, 39999),
            new Payment("Иванова Моника Карповна", 5, 8, 2023, 150000),
            new Payment("Иванов Иван Иванович", 9, 11, 2022, 555)};
    Payment[] res2 = {new Payment("Иванов Иван Иванович", 5, 8, 2023, 39999),
            new Payment("Иванов Иван Иванович", 9, 11, 2022, 555)};
    Payment[] res3 = {};
    FinanceReport one = new FinanceReport("Кристальная Катерина Андреевна", arr, 5, 11, 2023);
    FinanceReport oneRes1 = new FinanceReport("Кристальная Катерина Андреевна", res1, 5, 11, 2023);
    FinanceReport oneRes2 = new FinanceReport("Кристальная Катерина Андреевна", res2, 5, 11, 2023);
    FinanceReport oneRes3 = new FinanceReport("Кристальная Катерина Андреевна", res3, 5, 11, 2023);
    FinanceReport empty = new FinanceReport();

    @Test(expected = Exception.class)
    public void paymentsForSymbol() {
        assertEquals(oneRes1.toString(), FinanceReportProcessor.paymentsForSymbol('И', one).toString());
        assertEquals(empty.toString(), FinanceReportProcessor.paymentsForSymbol('И', empty).toString());
        assertEquals(oneRes3.toString(), FinanceReportProcessor.paymentsForSymbol('L', one).toString());
        FinanceReportProcessor.paymentsForSymbol('И', null);
    }

    @Test(expected = Exception.class)
    public void lesserPayments() {
        assertEquals(oneRes2.toString(), FinanceReportProcessor.lesserPayments(40000, one).toString());
        assertEquals(empty.toString(), FinanceReportProcessor.lesserPayments(500, empty).toString());
        assertEquals(oneRes3.toString(), FinanceReportProcessor.lesserPayments(0, one).toString());
        FinanceReportProcessor.lesserPayments(11, null);
        FinanceReportProcessor.lesserPayments(-11, one);
    }
}