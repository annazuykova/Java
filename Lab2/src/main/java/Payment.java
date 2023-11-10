import java.util.Objects;

public class Payment {
    private String fio;
    private int day, year, month;
    private int pay;

    public Payment() {
        fio = "Anna";
        pay = 0;
        day = 1;
        month = 1;
        year = 1999;
    }

    public Payment(String fio, int day, int month, int year, int pay) {
        if (fio == null) throw new NullPointerException("Строки не существует");
        if (pay < 0) throw new IllegalArgumentException("Платеж не может быть отрицательным");
        this.fio = fio;
        this.day = day;
        this.month = month;
        this.year = year;
        this.pay = pay;
    }

    public String getFio() {
        return fio;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getPay() {
        return pay;
    }

    public void setFio(String fio) {
        if (fio == null) throw new NullPointerException("Строки не существует");
        this.fio = fio;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPay(int pay) {
        if (pay < 0) throw new IllegalArgumentException("Платеж не может быть отрицательным");
        this.pay = pay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return day == payment.day && year == payment.year && month == payment.month && pay == payment.pay && Objects.equals(fio, payment.fio);
    }

    @Override
    public String toString() {
        return String.format("Плательщик: %s, дата: %d.%d.%d, сумма: %d руб. %d коп.,", fio, day, month, year, pay / 100, pay % 100);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, day, year, month, pay);
    }
}
