import junit.framework.TestCase;

public class StringProcessorTest extends TestCase {
    String s;
    StringBuilder s1;

    public void testStrMultiExceptionNull() {
        try {
            StringProcessor.strMulti(s, 1);
        } catch (NullPointerException e) {
            return;
        }
        fail("Исключение на несуществующую строку не работает");
    }

    public void testStrMultiExceptionEmptyString() {
        try {
            StringProcessor.strMulti("", 1);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("Исключение на пустую строку не работает");
    }


    public void testStrMultiExceptionIllegal() {
        try {
            StringProcessor.strMulti("string", -1);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("Исключение на отрицательные значения не работает");
    }

    public void testStrMulti() {
        assertEquals("aaa", StringProcessor.strMulti("a", 3));
        assertEquals("", StringProcessor.strMulti("ab", 0));
        assertEquals("   ", StringProcessor.strMulti(" ", 3));
    }

    public void testSearchCountExceptionNullOne() {
        try {
            StringProcessor.searchCount(s, "rt");
        } catch (NullPointerException e) {
            return;
        }
        fail("Исключение на несуществующую первую строку не работает");
    }

    public void testSearchCountExceptionNullTwo() {
        try {
            StringProcessor.searchCount("", s);
        } catch (NullPointerException e) {
            return;
        }
        fail("Исключение на несуществующую вторую строку не работает");
    }

    public void testSearchCountExceptionEmptyString() {
        try {
            StringProcessor.searchCount("aaa", "");
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("Исключение на пустую строку не работает");
    }

    public void testSearchCount() {
        assertEquals(3, StringProcessor.searchCount("121221223122", "122"));
        assertEquals(3, StringProcessor.searchCount("aaraaaf", "aa"));
        assertEquals(0, StringProcessor.searchCount("", "aa"));
        assertEquals(0, StringProcessor.searchCount("qwerty", "1"));
        assertEquals(4, StringProcessor.searchCount("aaaaa", "aa"));
        assertEquals(0, StringProcessor.searchCount("llrlll", "a"));
        assertEquals(6, StringProcessor.searchCount("aar aahaaf ", "a"));
        assertEquals(7, StringProcessor.searchCount(" aa r  a aha af ", " "));
        assertEquals(1, StringProcessor.searchCount("aaraaraataa", "aat"));

    }

    public void testReplaceNumToStrExceptionNull() {
        try {
            StringProcessor.replaceNumToStr(s);
        } catch (NullPointerException e) {
            return;
        }
        fail("Исключение на несуществующую строку не работает");
    }

    public void testReplaceNumToStr() {
        assertEquals("одиндватри", StringProcessor.replaceNumToStr("123"));
        assertEquals("одиндва0три", StringProcessor.replaceNumToStr("1203"));
        assertEquals("одиндва тритри", StringProcessor.replaceNumToStr("12 33"));
        assertEquals("4567", StringProcessor.replaceNumToStr("4567"));
    }

    public void testDeleteSecondCharExceptionNull() {
        try {
            StringProcessor.deleteSecondChar(s1);
        } catch (NullPointerException e) {
            return;
        }
        fail("Исключение на несуществующую строку не работает");
    }

    public void testDeleteSecondChar() {
        assertEquals("111", StringProcessor.deleteSecondChar(new StringBuilder("121212")).toString());
        assertEquals("авдё", StringProcessor.deleteSecondChar(new StringBuilder("абвгдеё")).toString());
        assertEquals(" ", StringProcessor.deleteSecondChar(new StringBuilder("  ")).toString());


    }
}