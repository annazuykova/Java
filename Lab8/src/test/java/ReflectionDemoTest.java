import org.junit.Test;

import java.util.ArrayList;
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
        List<String> expected = List.of("getName", "equals", "hashCode", "setName", "setFamilia",
                "setAge", "setOtchestvo", "getAge", "getOtchestvo", "getFamilia", "wait", "wait",
                "wait", "toString", "getClass", "notify", "notifyAll");
        List<String> result = ReflectionDemo.getPublicMethods(new Human("Krasnova", "Sena", "Olegovna", 12));
        assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }

    @Test
    public void getPublicMethodsTestTwo() {
        List<String> expected = List.of("getName", "equals", "hashCode", "setName", "setFamilia",
                "setAge", "setOtchestvo", "getAge", "getOtchestvo", "getFamilia", "getFaculty", "setFaculty", "wait", "wait",
                "wait", "toString", "getClass", "notify", "notifyAll");
        List<String> result = ReflectionDemo.getPublicMethods(new Student("Krasnova", "Sena", "Olegovna", 12, "FCTK"));
        assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }

    @Test
    public void getPublicMethodsTestThree() {
        List<String> expected = List.of("equals", "hashCode", "wait", "wait",
                "wait", "toString", "getClass", "notify", "notifyAll");
        List<String> result = ReflectionDemo.getPublicMethods(new Object());
        assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }


    @Test
    public void getListSuperClassesTestOne() throws ClassNotFoundException {
        List<String> expected = List.of("Human", "java.lang.Object");
        List<String> result = ReflectionDemo.getListSuperClasses(new Student("Krasnova", "Sena", "Olegovna", 12, "Math"));
        assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }

    @Test
    public void getListSuperClassesTestTwo() throws ClassNotFoundException {
        List<String> expected = List.of("java.lang.Number", "java.lang.Object");
        List<String> result = ReflectionDemo.getListSuperClasses(1);
        assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }

    @Test(expected = NullPointerException.class)
    public void getListSuperClassesTestThree() throws ClassNotFoundException {
        ReflectionDemo.getListSuperClasses(new Object());
    }
}