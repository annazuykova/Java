public class StringProcessor {

    public static void main(String[] args) {
    }

    public static StringBuilder strMulti(String s, int n) {
        StringBuilder res = new StringBuilder("");
        if (s == null) throw new NullPointerException("Строки для не существует");
        if (n < 0) throw new IllegalArgumentException("Число копирований не может быть отрицательным");
        if (s.equals("")) throw new IllegalArgumentException("Введена пустая строка");
        for (int i = 0; i < n; i++) {
            res.append(s);
        }
        return res;
    }

    public static int searchCount(String s1, String s2) {
        int res = 0, j = 0, k = 0;
        if (s1 == null) throw new NullPointerException("Строки, в которой ищем, не существует");
        if (s2 == null) throw new NullPointerException("Строки, которую ищем, не существует");
        if (s2.equals("")) throw new IllegalArgumentException("Введена пустая строка");
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                k = 1;
                //проверка на выход за границы + сравнение символов со следующего:
                while ((i + k < s1.length()) && (k < s2.length()) && (s1.charAt(i + k) == s2.charAt(k))) {
                    k++;
                }
            }
            if (k == s2.length()) res++;
            k = 0;
        }
        return res;
    }

    public static String replaceNumToStr(String s1) {
        StringBuilder res = new StringBuilder("");
        if (s1 == null) throw new NullPointerException("Строки не существует");
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '1') {
                res.append("один");
            } else if (s1.charAt(i) == '2') {
                res.append("два");
            } else if (s1.charAt(i) == '3') {
                res.append("три");
            } else {
                res.append(s1.charAt(i));
            }
        }
        return res.toString();
    }

    public static StringBuilder deleteSecondChar(StringBuilder s) {
        int tmp = 0;
        if (s == null) throw new NullPointerException("Строки не существует");
        int n = s.length();
        for (int i = 1; i < n + 1; i++) {
            if (i % 2 == 0) {
                tmp++;
                s.deleteCharAt(i - tmp);
            }
        }
        return s;
    }
}
