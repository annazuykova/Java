public class FinanceReport {
    private String fioReport;
    private int day, year, month;
    private Payment[] payments;

    public static void main(String[] args) {
        Payment[] arr = {new Payment("Иванов Иван Иванович", 5, 8, 2023, 39001),
                new Payment("Иванова Моника Карповна", 5, 8, 2023, 150000),
                new Payment("Иванов Иван Иванович", 9, 11, 2022, 555),
                new Payment("Куровский Иван Петрович", 25, 1, 2020, 6545683)};
        FinanceReport one = new FinanceReport("Кристальная Катерина Андреевна", arr, 5, 11, 2023);
        System.out.println(one.toString());
    }
    public FinanceReport() {
        fioReport = new String();
        payments = new Payment[0];
        day = 0;
        month = 0;
        year = 0;
    }

    public FinanceReport(String fioReport, Payment[] payments, int day, int month, int year) {
        if (fioReport == null) throw new NullPointerException("Строки не существует");
        if (payments == null) throw new NullPointerException("Массива платежей не существует");
        this.payments = payments;
        this.fioReport = fioReport;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public FinanceReport(FinanceReport obj1) {
        if (obj1 == null) throw new NullPointerException("Объект не существует");
        int n = obj1.countPayments();
        payments = new Payment[n];
        fioReport = obj1.getFioReport();
        day = obj1.day;
        month = obj1.month;
        year = obj1.year;
        for (int i = 0; i < n; i++) {
            payments[i] = new Payment(
                    obj1.getPayment(i).getFio(),
                    obj1.getPayment(i).getDay(),
                    obj1.getPayment(i).getMonth(),
                    obj1.getPayment(i).getYear(),
                    obj1.getPayment(i).getPay()
            );
        }
    }

    public String getFioReport() {
        return fioReport;
    }

    public void setFioReport(String fioReport) {
        if (fioReport == null) throw new NullPointerException("Строки не существует");
        this.fioReport = fioReport;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Payment getPayment(int idx) {
        if (idx < 0 || idx > countPayments()) throw new IllegalArgumentException("Индекс вне границ массива");
        return payments[idx];
    }

    public Payment[] getPayments() {
        return payments;
    }

    public void setPayment(int idx, Payment replace) {
        if (replace == null) throw new NullPointerException("Платежа не существует");
        if (idx < 0 || idx > countPayments()) throw new IllegalArgumentException("Индекс вне границ массива");
        payments[idx].setPay(replace.getPay());
        payments[idx].setFio(replace.getFio());
        payments[idx].setDay(replace.getDay());
        payments[idx].setMonth(replace.getMonth());
        payments[idx].setYear(replace.getYear());
    }

    public int countPayments() {
        return payments == null ? 0 : payments.length;
    }

    @Override
    public String toString() {
        int n = countPayments();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (payments[i] != null) {
                tmp.append("\n\t" + payments[i].toString());
            }
        }
        String s = String.format("[Автор:%s, дата:%d.%d.%d, Платежи: [%s]]", fioReport, day, month, year, tmp);
        return s;
    }

}