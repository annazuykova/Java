public class FinanceReportProcessor {
    public static FinanceReport paymentsForSymbol(char symbol, FinanceReport obj) {
        if (obj == null) throw new NullPointerException("Объекта не существует");
        int n = obj.countPayments();
        int j = 0;
        Payment[] arr = new Payment[n];
        for (int i = 0; i < n; i++) {
            if (obj.getPayment(i).getFio().charAt(0) == symbol) {
                arr[j] = obj.getPayment(i);
                j++;
            }
        }
        Payment[] res = new Payment[j];
        for (int i = 0; i < j; i++) {
            res[i] = arr[i];
        }
        return new FinanceReport(obj.getFioReport(), res, obj.getDay(), obj.getMonth(), obj.getYear());
    }

    public static FinanceReport lesserPayments(int payment, FinanceReport obj) {
        if (obj == null) throw new NullPointerException("Объекта не существует");
        if (payment < 0) throw new IllegalArgumentException("Платеж не может быть отрицательным");
        int n = obj.countPayments();
        int j = 0;
        Payment[] arr = new Payment[n];
        for (int i = 0; i < n; i++) {
            if (obj.getPayment(i).getPay() < payment) {
                arr[j] = obj.getPayment(i);
                j++;
            }
        }
        Payment[] res = new Payment[j];
        for (int i = 0; i < j; i++) {
            res[i] = arr[i];
        }
        return new FinanceReport(obj.getFioReport(), res, obj.getDay(), obj.getMonth(), obj.getYear());
    }
}
