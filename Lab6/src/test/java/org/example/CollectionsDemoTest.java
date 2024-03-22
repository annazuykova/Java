package org.example;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CollectionsDemoTest {

    @Test
    public void countFirstChar1() {
        List<String> list = List.of("one", "two", "oo", "three", "0", "qwerty");
        assertEquals(2, CollectionsDemo.countFirstChar(list, 'o'));
    }

    @Test
    public void countFirstChar2() {
        List<String> list = List.of("one", "two", "oo", "three", "0", "qwerty");
        assertEquals(1, CollectionsDemo.countFirstChar(list, '0'));
    }

    @Test
    public void countFirstChar3() {
        List<String> list = List.of("one", "two", "oo", "three", "0", "qwerty");
        assertEquals(0, CollectionsDemo.countFirstChar(list, 'e'));
    }

    @Test(expected = NullPointerException.class)
    public void countFirstCharException() {
        List<String> list = null;
        CollectionsDemo.countFirstChar(list, 'e');
    }

    @Test
    public void copyWithoutHuman1() {
        List<Human> list = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                new Human("Ivanov", "Ivan", "Petrovich", 22),
                new Human("Eshevika", "Malina", "Gennadievna", 90),
                new Human("Rukola", "Karina", "Salatovna", 45),
                new Human("Ivanov", "Ivan", "Petrovich", 22),
                new Human("Rukola", "Karina", "Salatovna", 44));
        List<Human> listRes = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                new Human("Eshevika", "Malina", "Gennadievna", 90),
                new Human("Rukola", "Karina", "Salatovna", 45),
                new Human("Rukola", "Karina", "Salatovna", 44));
        assertEquals(listRes, CollectionsDemo.copyWithoutHuman(list, new Human("Ivanov", "Ivan", "Petrovich", 22)));
        list.get(0).setAge(25);
        System.out.println(listRes.get(0).getAge());
    }

    @Test
    public void copyWithoutHuman2() {
        List<Human> list = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                new Human("Rukola", "Karina", "Salatovna", 45),
                new Human("Ivanov", "Ivan", "Petrovich", 22),
                new Human("Rukola", "Karina", "Salatovna", 44));
        List<Human> listRes = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                new Human("Ivanov", "Ivan", "Petrovich", 22),
                new Human("Rukola", "Karina", "Salatovna", 44));
        assertEquals(listRes, CollectionsDemo.copyWithoutHuman(list, new Human("Rukola", "Karina", "Salatovna", 45)));
    }

    @Test
    public void copyWithoutHuman3() {
        List<Human> list = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                new Human("Rukola", "Karina", "Salatovna", 45),
                new Human("Ivanov", "Ivan", "Petrovich", 22),
                new Human("Rukola", "Karina", "Salatovna", 44));
        assertEquals(list, CollectionsDemo.copyWithoutHuman(list, new Human("Ruzanova", "Margo", "Tarasovna", 45)));
    }

    @Test
    public void copyWithoutHuman4() {
        List<Human> list = new ArrayList<>();
        assertEquals(list, CollectionsDemo.copyWithoutHuman(list, new Human("Ruzanova", "Margo", "Tarasovna", 45)));
    }

    @Test(expected = NullPointerException.class)
    public void copyWithoutHumanException1() {
        CollectionsDemo.copyWithoutHuman(null, new Human("Ruzanova", "Margo", "Tarasovna", 45));
    }
    @Test(expected = NullPointerException.class)
    public void copyWithoutHumanException2() {
        List<Human> list = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                new Human("Rukola", "Karina", "Salatovna", 45));
        CollectionsDemo.copyWithoutHuman(list,  null);
    }
    @Test(expected = NullPointerException.class)
    public void copyWithoutHumanException3() {
        List<Human> list = List.of(new Human("Krasnova", "Sena", "Olegovna", 12),
                null);
        CollectionsDemo.copyWithoutHuman(list, new Human("Ruzanova", "Margo", "Tarasovna", 45));
    }

    @Test
    public void setWithoutIntersection1() {
        HashSet<Integer> set1 = new HashSet<>();
        Collections.addAll(set1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        HashSet<Integer> set2 = new HashSet<>();
        Collections.addAll(set2, 2, 4, 6, 8, 0);
        HashSet<Integer> set3 = new HashSet<>();
        Collections.addAll(set3, 1, 3, 5, 7, 9);
        List<Set<Integer>> list = List.of(set1, set2, set3);
        List<Set<Integer>> listRes = List.of(set2);
        assertEquals(listRes, CollectionsDemo.setWithoutIntersection(list, set3));
    }

    @Test
    public void setWithoutIntersection2() {
        HashSet<Integer> set1 = new HashSet<>();
        Collections.addAll(set1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        HashSet<Integer> set2 = new HashSet<>();
        Collections.addAll(set2, 2, 4, 6, 8, 0);
        HashSet<Integer> set3 = new HashSet<>();
        Collections.addAll(set3, 1, 3, 5, 7, 9);
        List<Set<Integer>> list = List.of(set1, set2, set3);
        assertEquals(new ArrayList<HashSet<Integer>>(), CollectionsDemo.setWithoutIntersection(list, set1));
    }

    @Test
    public void setWithoutIntersection3() {
        HashSet<Integer> set1 = new HashSet<>();
        Collections.addAll(set1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        HashSet<Integer> set2 = new HashSet<>();
        Collections.addAll(set2, 3, 4, 6, 8, 0);
        HashSet<Integer> set3 = new HashSet<>();
        Collections.addAll(set3, 1, 3, 5, 7, 9);
        HashSet<Integer> set4 = new HashSet<>();
        Collections.addAll(set4, 11, 15, 2);
        List<Set<Integer>> list = List.of(set1, set2, set3);
        List<HashSet<Integer>> listRes = List.of(set2, set3);
        assertEquals(listRes, CollectionsDemo.setWithoutIntersection(list, set4));
    }

    @Test(expected = NullPointerException.class)
    public void setWithoutIntersectionException1() {
        HashSet<Integer> set1 = new HashSet<>();
        Collections.addAll(set1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        HashSet<Integer> set2 = new HashSet<>();
        Collections.addAll(set2, 3, 4, 6, 8, 0);
        List<Set<Integer>> list = List.of(set1, set2);
        CollectionsDemo.setWithoutIntersection(list, null);
    }

    @Test(expected = NullPointerException.class)
    public void setWithoutIntersectionException2() {
        HashSet<Integer> set2 = new HashSet<>();
        Collections.addAll(set2, 3, 4, 6, 8, 0);
        HashSet<Integer> set3 = new HashSet<>();
        Collections.addAll(set3, 1, 3, 5, 7, 9);
        List<Set<Integer>> list = List.of(null, set2, set3);
        CollectionsDemo.setWithoutIntersection(list, set2);
    }

    @Test(expected = NullPointerException.class)
    public void setWithoutIntersectionException3() {
        HashSet<Integer> set1 = new HashSet<>();
        Collections.addAll(set1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        CollectionsDemo.setWithoutIntersection(null, set1);
    }

    @Test
    public void setMatchId1() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, new Human("Krasnova", "Sena", "Olegovna", 12));
        map.put(2, new Human("Rukola", "Karina", "Salatovna", 45));
        map.put(3, new Human("Ivanov", "Ivan", "Petrovich", 22));
        map.put(4, new Human("Eshevika", "Malina", "Gennadievna", 90));
        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set, 1, 3);
        HashSet<Human> setPeople = new HashSet<>();
        Collections.addAll(setPeople, map.get(1), map.get(3));
        assertEquals(setPeople, CollectionsDemo.SetMatchId(map, set));
    }

    @Test
    public void setMatchId2() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, new Human("Krasnova", "Sena", "Olegovna", 12));
        map.put(2, new Human("Rukola", "Karina", "Salatovna", 45));
        map.put(3, new Human("Ivanov", "Ivan", "Petrovich", 22));
        map.put(4, new Human("Eshevika", "Malina", "Gennadievna", 90));
        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set, 1, 2, 5, 7);
        HashSet<Human> setPeople = new HashSet<>();
        Collections.addAll(setPeople, map.get(1), map.get(2));
        assertEquals(setPeople, CollectionsDemo.SetMatchId(map, set));
    }

    @Test
    public void setMatchId3() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, new Human("Krasnova", "Sena", "Olegovna", 12));
        map.put(2, new Human("Rukola", "Karina", "Salatovna", 45));
        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set, 5, 7, 9);
        HashSet<Human> setPeople = new HashSet<>();
        assertEquals(setPeople, CollectionsDemo.SetMatchId(map, set));
    }

    @Test(expected = NullPointerException.class)
    public void setMatchIdException1() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, new Human("Krasnova", "Sena", "Olegovna", 12));
        map.put(2, new Human("Rukola", "Karina", "Salatovna", 45));
        map.put(3, null);
        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set, 1, 2, 3, 4, 6);
        CollectionsDemo.SetMatchId(map, set);
    }

    @Test(expected = NullPointerException.class)
    public void setMatchIdException2() {
        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set, 1, 2, 4, 6);
        CollectionsDemo.SetMatchId(null, set);
    }

    @Test(expected = NullPointerException.class)
    public void setMatchIdException3() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, new Human("Krasnova", "Sena", "Olegovna", 12));
        map.put(2, new Human("Rukola", "Karina", "Salatovna", 45));
        CollectionsDemo.SetMatchId(map, null);
    }

    @Test
    public void listId1() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, new Human("Krasnova", "Sena", "Olegovna", 12));
        map.put(2, new Human("Rukola", "Karina", "Salatovna", 18));
        map.put(3, new Human("Ivanov", "Ivan", "Petrovich", 22));
        map.put(4, new Human("Eshevika", "Malina", "Gennadievna", 90));
        List<Integer> list = List.of(2,3, 4);
        assertEquals(list, CollectionsDemo.ListId(map));
    }

    @Test
    public void listId2() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, new Human("Krasnova", "Sena", "Olegovna", 12));
        map.put(2, new Human("Rukola", "Karina", "Salatovna", 17));
        map.put(3, new Human("Ivanov", "Ivan", "Petrovich", 2));
        map.put(4, new Human("Eshevika", "Malina", "Gennadievna", 9));
        assertEquals(new ArrayList<>(), CollectionsDemo.ListId(map));
    }

    @Test
    public void listId3() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, new Human("Krasnova", "Sena", "Olegovna", 12));
        map.put(2, new Human("Rukola", "Karina", "Salatovna", 18));
        map.put(3, new Human("Ivanov", "Ivan", "Petrovich", 19));
        map.put(4, new Human("Eshevika", "Malina", "Gennadievna", 18));
        List<Integer> list = List.of(2,3,4);
        assertEquals(list, CollectionsDemo.ListId(map));
    }

    @Test(expected = NullPointerException.class)
    public void listIdException1() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, new Human("Krasnova", "Sena", "Olegovna", 12));
        map.put(2, new Human("Rukola", "Karina", "Salatovna", 18));
        map.put(3, null);
        map.put(4, new Human("Eshevika", "Malina", "Gennadievna", 18));
        CollectionsDemo.ListId(map);
    }

    @Test(expected = NullPointerException.class)
    public void listIdException2() {
        CollectionsDemo.ListId(null);
    }

    @Test
    public void mapOfAges1() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, new Human("Krasnova", "Sena", "Olegovna", 12));
        map.put(2, new Human("Rukola", "Karina", "Salatovna", 10));
        map.put(3, new Human("Ivanov", "Ivan", "Petrovich", 10));
        map.put(4, new Human("Eshevika", "Malina", "Gennadievna", 56));
        Map<Integer, Integer> mapRes = new HashMap<>();
        mapRes.put(1, 12);
        mapRes.put(2, 10);
        mapRes.put(3, 10);
        mapRes.put(4, 56);
        assertEquals(mapRes, CollectionsDemo.MapOfAges(map));
    }

    @Test
    public void mapOfAges2() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, new Human("Krasnova", "Sena", "Olegovna", 11));
        map.put(2, new Human("Rukola", "Karina", "Salatovna", 10));
        map.put(30, new Human("Ivanov", "Ivan", "Petrovich", 0));
        map.put(4, new Human("Eshevika", "Malina", "Gennadievna", 12));
        Map<Integer, Integer> mapRes = new HashMap<>();
        mapRes.put(1, map.get(1).getAge());
        mapRes.put(2, map.get(2).getAge());
        mapRes.put(30, map.get(30).getAge());
        mapRes.put(4, map.get(4).getAge());
        assertEquals(mapRes, CollectionsDemo.MapOfAges(map));
    }

    @Test
    public void mapOfAges3() {
        assertEquals(new HashMap<Integer, Integer>(), CollectionsDemo.MapOfAges(new HashMap<Integer, Human>()));
    }

    @Test(expected = NullPointerException.class)
    public void mapOfAgesException1() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, new Human("Krasnova", "Sena", "Olegovna", 11));
        map.put(2, null);
        map.put(3, new Human("Ivanov", "Ivan", "Petrovich", 0));
        map.put(4, new Human("Eshevika", "Malina", "Gennadievna", 12));
        CollectionsDemo.MapOfAges(map);
    }

    @Test(expected = NullPointerException.class)
    public void mapOfAgesException2() {
        CollectionsDemo.MapOfAges(null);
    }

    @Test
    public void mapOfAgesLists1() {
        HashSet<Human> set1 = new HashSet<>();
        Collections.addAll(set1, new Human("Krasnova", "Sena", "Olegovna", 12),
                new Human("Ivanov", "Ivan", "Petrovich", 89),
                new Human("Eshevika", "Malina", "Gennadievna", 12));
        Map<Integer, List<Human>> map = new HashMap<>();
        List<Human> list1 = List.of(new Human("Eshevika", "Malina", "Gennadievna", 12),new Human("Krasnova", "Sena", "Olegovna", 12));
        List<Human> list2 = List.of(new Human("Ivanov", "Ivan", "Petrovich", 89));
        map.put(12, list1);
        map.put(89, list2);
        assertEquals(map, CollectionsDemo.MapOfAgesLists(set1));
    }

    @Test
    public void mapOfAgesLists2() {
        HashSet<Human> set1 = new HashSet<>();
        Collections.addAll(set1, new Human("Krasnova", "Sena", "Olegovna", 25),
                new Human("Ivanov", "Ivan", "Petrovich", 25),
                new Human("Eshevika", "Malina", "Gennadievna", 25));
        Map<Integer, List<Human>> map = new HashMap<>();
        List<Human> list1 = List.of(
                new Human("Ivanov", "Ivan", "Petrovich", 25),
                new Human("Krasnova", "Sena", "Olegovna", 25),
                new Human("Eshevika", "Malina", "Gennadievna", 25));
        map.put(25, list1);
        assertEquals(map, CollectionsDemo.MapOfAgesLists(set1));
    }

    @Test
    public void mapOfAgesLists3() {
        Set<Human> set1 = new HashSet<>();
        Map<Integer, List<Human>> map = new HashMap<>();
        assertEquals(map, CollectionsDemo.MapOfAgesLists(set1));
    }

    @Test(expected = NullPointerException.class)
    public void mapOfAgesListsException1() {
        CollectionsDemo.MapOfAgesLists(null);
    }

    @Test(expected = NullPointerException.class)
    public void mapOfAgesListsException2() {
        HashSet<Human> set1 = new HashSet<>();
        Collections.addAll(set1, null,
                new Human("Ivanov", "Ivan", "Petrovich", 89));
        CollectionsDemo.MapOfAgesLists(set1);
    }
}