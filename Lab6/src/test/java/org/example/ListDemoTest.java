package org.example;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ListDemoTest {

    @Test
    public void familiaList() {
        List<? extends Human> list = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                new Human("Ivanov", "Ivan", "Petrovich", 22),
                new Student("Rukola", "Sena", "Olegovna", 22, "FE"),
                new Human("Rukola", "Karina", "Salatovna", 45),
                new Student("Ivanov", "Ivan", "Petrovich", 23, "FL"),
                new Human("Rukola", "Marina", "Salatovna", 44));
        List<? extends Human> res = List.of(
                new Student("Rukola", "Sena", "Olegovna", 22, "FE"),
                new Human("Rukola", "Karina", "Salatovna", 45),
                new Human("Rukola", "Marina", "Salatovna", 44));
        assertEquals(res, ListDemo.familiaList(list, new Student("Rukola", "Dina", "Olegovna", 19, "FT")));
    }

    @Test
    public void familiaList2() {
        List<? extends Human> list = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                new Human("Ivanov", "Ivan", "Petrovich", 22),
                new Student("Ivanova", "Sena", "Olegovna", 22, "FE"),
                new Human("Ivanova", "Karina", "Salatovna", 45),
                new Student("Ivanov", "Ivan", "Petrovich", 23, "FL"),
                new Human("Rukola", "Marina", "Salatovna", 44));
        List<? extends Human> res = List.of(
                new Student("Ivanova", "Sena", "Olegovna", 22, "FE"),
                new Human("Ivanova", "Karina", "Salatovna", 45));
        assertEquals(res, ListDemo.familiaList(list, new Student("Ivanova", "Dina", "Olegovna", 18, "FT")));
    }

    @Test
    public void familiaList3() {
        List<Human> list = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                new Human("Ivanov", "Ivan", "Petrovich", 22),
                new Student("Ivanova", "Sena", "Olegovna", 22, "FE"),
                new Human("Ivanova", "Karina", "Salatovna", 45));
        assertEquals(new ArrayList<Human>(), ListDemo.familiaList(list, new Student("Popova", "Dina", "Olegovna", 18, "FT")));
    }

    @Test(expected = NullPointerException.class)
    public void familiaListException1() {
        ListDemo.familiaList(null, new Human("Ruzanova", "Margo", "Tarasovna", 45));
    }

    @Test(expected = NullPointerException.class)
    public void familiaListException2() {
        List<? extends Human> list = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                new Human("Rukola", "Karina", "Salatovna", 45),
                new Student("Ivanova", "Sena", "Olegovna", 22, "FE"));
        ListDemo.familiaList(list, null);
    }

    @Test(expected = NullPointerException.class)
    public void familiaListException3() {
        List<Human> list = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                null);
        ListDemo.familiaList(list, new Human("Ruzanova", "Margo", "Tarasovna", 45));
    }

    @Test
    public void setHumanMaxAge1() {
        List<? extends Human> list = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                new Human("Ivanov", "Ivan", "Petrovich", 45),
                new Student("Ivanova", "Sena", "Olegovna", 22, "FE"),
                new Human("Ivanova", "Karina", "Salatovna", 45),
                new Student("Ivanov", "Ivan", "Petrovich", 23, "FL"),
                new Human("Rukola", "Marina", "Salatovna", 44));
        HashSet<Human> set = new HashSet<>();
        Collections.addAll(set, new Human("Ivanov", "Ivan", "Petrovich", 45),
                new Human("Ivanova", "Karina", "Salatovna", 45));
        assertEquals(set, ListDemo.setHumanMaxAge(list));
    }

    @Test
    public void setHumanMaxAge2() {
        List<? extends Human> list = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                new Human("Ivanov", "Ivan", "Petrovich", 12),
                new Student("Ivanova", "Sena", "Olegovna", 22, "FE"),
                new Human("Ivanova", "Karina", "Salatovna", 11),
                new Student("Ivanov", "Ivan", "Petrovich", 23, "FL"),
                new Human("Rukola", "Marina", "Salatovna", 23));
        HashSet<Human> set = new HashSet<>();
        Collections.addAll(set, new Student("Ivanov", "Ivan", "Petrovich", 23, "FL"),
                new Human("Rukola", "Marina", "Salatovna", 23));
        assertEquals(set, ListDemo.setHumanMaxAge(list));
    }

    @Test
    public void setHumanMaxAge3() {
        List<? extends Human> list = new ArrayList<>();
        assertEquals(new HashSet<Human>(), ListDemo.setHumanMaxAge(list));
    }

    @Test(expected = NullPointerException.class)
    public void setHumanMaxAgeException1() {
        ListDemo.setHumanMaxAge(null);
    }

    @Test(expected = NullPointerException.class)
    public void setHumanMaxAgeException2() {
        List<? extends Human> list = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                null,
                new Student("Ivanova", "Sena", "Olegovna", 22, "FE"));
        ListDemo.setHumanMaxAge(list);
    }
}