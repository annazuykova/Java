import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LambdaRunnerTest {

    @Test
    public void runFunctionGetLengthTest1() {
        assertEquals(10, (int) LambdaRunner.runFunction(LambdaDemo.getLength, "qwertyuiop"));
    }

    @Test
    public void runFunctionGetLengthTest2() {
        assertEquals(0, (int) LambdaRunner.runFunction(LambdaDemo.getLength, ""));
    }

    @Test
    public void runFunctionGetFirstCharTest1() {
        assertEquals('a', (char) LambdaRunner.runFunction(LambdaDemo.getFirstChar, "anna"));
    }

    @Test
    public void runFunctionGetFirstCharTest2() {
        assertTrue(null == LambdaRunner.runFunction(LambdaDemo.getFirstChar, ""));
    }

    @Test
    public void runFunctionCountWordsTest1() {
        assertEquals(4, (int) LambdaRunner.runFunction(LambdaDemo.countWords, "qwose,djf,v,y"));
    }

    @Test
    public void runFunctionCountWordsTest2() {
        assertEquals(1, (int) LambdaRunner.runFunction(LambdaDemo.countWords, "dfgh"));
    }

    @Test
    public void runFunctionCountWordsTest3() {
        assertEquals(0, (int) LambdaRunner.runFunction(LambdaDemo.countWords, ""));
    }

    @Test
    public void runFunctionGetAgeHumansTest1() {
        assertEquals(23, (int) LambdaRunner.runFunction(LambdaDemo.getAgeHuman,
                new Student("Kim", "Margo", "Leonidovna", 23, GENDER.WOMAN,
                        "FCTC", "OMSU", "Programmer")));
    }

    @Test
    public void runFunctionGetAgeHumanTest2() {
        assertEquals(24, (int) LambdaRunner.runFunction(LambdaDemo.getAgeHuman,
                new Human("Kim", "Dmitry", "Ivanovich", 24, GENDER.MAN)));
    }

    @Test
    public void runFunctionGetFullNameTest1() {
        assertEquals("Kim Margo Leonidovna", LambdaRunner.runFunction(LambdaDemo.getFullName,
                new Student("Kim", "Margo", "Leonidovna", 23, GENDER.WOMAN,
                        "FCTC", "OMSU", "Programmer")));
    }

    @Test
    public void runFunctionGetFullNameTest2() {
        assertEquals("Kim Dmitry Ivanovich", LambdaRunner.runFunction(LambdaDemo.getFullName,
                new Human("Kim", "Dmitry", "Ivanovich", 24, GENDER.MAN)));
    }

    @Test
    public void runPredicateCheckWithoutGapTest1() {
        assertTrue(LambdaRunner.runPredicate(LambdaDemo.checkWithoutGap, "123yugvf"));
    }

    @Test
    public void runPredicateCheckWithoutGapTest2() {
        assertFalse(LambdaRunner.runPredicate(LambdaDemo.checkWithoutGap, "123 yu gvf"));
    }

    @Test
    public void runPredicateCheckFamiliaTest1() {
        assertTrue(LambdaRunner.runBiPredicate(LambdaDemo.checkFamilia,
                new Human("Kim", "Dmitry", "Ivanovich", 24, GENDER.MAN),
                new Student("Kim", "Margo", "Leonidovna", 23, GENDER.WOMAN,
                        "FCTC", "OMSU", "Programmer")
        ));
    }

    @Test
    public void runPredicateCheckFamiliaTest2() {
        assertFalse(LambdaRunner.runBiPredicate(LambdaDemo.checkFamilia,
                new Human("Kim", "Dmitry", "Ivanovich", 24, GENDER.MAN),
                new Human("Rukola", "Margo", "Leonidovna", 23, GENDER.WOMAN)));
    }


    @Test
    public void runUnaryOperatorDoOlderTest1() {
        Human human = new Human("Rukola", "Margo", "Leonidovna", 24, GENDER.WOMAN);
        assertEquals(human, LambdaRunner.runUnaryOperator(LambdaDemo.doOlder, new Human("Rukola", "Margo", "Leonidovna", 23, GENDER.WOMAN)));
    }

    @Test
    public void runUnaryOperatorDoOlderTest2() {
        Human human = new Human("Rukola", "Margo", "Leonidovna", 24, GENDER.WOMAN);
        assertEquals(human, LambdaRunner.runUnaryOperator(LambdaDemo.doOlder, new Human("Rukola", "Margo", "Leonidovna", 23, GENDER.WOMAN)));
    }

    @Test
    public void runUnaryOperatorDoOlderTest3() {
        Student student = new Student("Kim", "Margo", "Leonidovna", 24, GENDER.WOMAN,
                "FCTC", "OMSU", "Programmer");
        assertEquals(student.getAge(), (LambdaRunner.runUnaryOperator(LambdaDemo.doOlder,
                new Student("Kim", "Margo", "Leonidovna", 23, GENDER.WOMAN,
                        "FCTC", "OMSU", "Programmer"))).getAge());
    }


    @Test
    public void runBiPredicateCheckAgeTest1() {
        List<Human> list = Arrays.asList(new Human("Kim", "Dmitry", "Ivanovich", 24, GENDER.MAN),
                new Human("Rukola", "Margo", "Leonidovna", 23, GENDER.WOMAN),
                new Human("Rukola", "Sofi", "Leonidovna", 40, GENDER.WOMAN));
        assertTrue(LambdaRunner.runBiPredicate(LambdaDemo.checkAge, list, 50));
    }

    @Test
    public void runBiPredicateCheckAgeTest2() {
        List<Human> list = Arrays.asList(new Human("Kim", "Dmitry", "Ivanovich", 24, GENDER.MAN),
                new Human("Rukola", "Margo", "Leonidovna", 23, GENDER.WOMAN),
                new Human("Rukola", "Sofi", "Leonidovna", 40, GENDER.WOMAN));
        assertFalse(LambdaRunner.runBiPredicate(LambdaDemo.checkAge, list, 24));
    }
}