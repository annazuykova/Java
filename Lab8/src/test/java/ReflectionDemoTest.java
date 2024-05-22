import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ReflectionDemoTest {

    @Test
    public void countHumanTestOne() {
        List<Object> list = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                new Human("Ivanov", "Ivan", "Petrovich", 22),
                new Student("Rukola", "Sena", "Olegovna", 22, "FE"),
                new Human("Rukola", "Karina", "Salatovna", 45),
                new Student("Ivanov", "Ivan", "Petrovich", 23, "FL"),
                new Human("Rukola", "Marina", "Salatovna", 44),
                "String",
                new Object());
        assertEquals(6, ReflectionDemo.countHuman(list));
    }

    @Test
    public void countHumanTestTwo() {
        List<Object> list = List.of("",
                1,
                new ArrayList<>(),
                "String",
                new Object());
        assertEquals(0, ReflectionDemo.countHuman(list));
    }


    @Test
    public void getPublicMethodsTestOne() {
        List<String> expected = Arrays.asList("getName", "equals", "hashCode", "setName", "setFamilia",
                "setAge", "setOtchestvo", "getAge", "getOtchestvo", "getFamilia", "wait", "wait",
                "wait", "toString", "getClass", "notify", "notifyAll");
        List<String> result = ReflectionDemo.getPublicMethods(new Human("Krasnova", "Sena", "Olegovna", 12));
        assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }

    @Test
    public void getPublicMethodsTestTwo() {
        List<String> expected = Arrays.asList("getName", "equals", "hashCode", "setName", "setFamilia",
                "setAge", "setOtchestvo", "getAge", "getOtchestvo", "getFamilia", "getFaculty", "setFaculty", "wait", "wait",
                "wait", "toString", "getClass", "notify", "notifyAll");
        List<String> result = ReflectionDemo.getPublicMethods(new Student("Krasnova", "Sena", "Olegovna", 12, "FCTK"));
        assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }

    @Test
    public void getPublicMethodsTestThree() {
        List<String> expected = Arrays.asList("equals", "hashCode", "wait", "wait",
                "wait", "toString", "getClass", "notify", "notifyAll");
        List<String> result = ReflectionDemo.getPublicMethods(new Object());
        Collections.sort(expected);
        Collections.sort(result);
        assertEquals(expected,result);
    }


    @Test
    public void getListSuperClassesTestOne() throws ClassNotFoundException {
        List<String> expected = Arrays.asList("Human", "Object");
        List<String> result = ReflectionDemo.getListSuperClasses(new Student("Krasnova", "Sena", "Olegovna", 12, "Math"));
        Collections.sort(expected);
        Collections.sort(result);
        assertEquals(expected,result);
    }

    @Test
    public void getListSuperClassesTestTwo() throws ClassNotFoundException {
        List<String> expected = Arrays.asList("Number", "Object");
        List<String> result = ReflectionDemo.getListSuperClasses(1);
        Collections.sort(expected);
        Collections.sort(result);
        assertEquals(expected,result);
    }

    @Test(expected = NullPointerException.class)
    public void getListSuperClassesTestThree() throws ClassNotFoundException {
        ReflectionDemo.getListSuperClasses(new Object());
    }
}