package org.example;

import java.util.*;

public class CollectionsDemo {

    public static int countFirstChar(List<String> list, char symbol) { // 1
        if (list == null) throw new NullPointerException("Списка не существует");
        int count = 0;
        for (String temp : list) {
            if (temp.charAt(0) == symbol) count++;
        }
        return count;
    }

    public static List<Human> copyWithoutHuman(List<Human> list, Human human) { // 3
        if (list == null) throw new NullPointerException("Списка не существует");
        if (human == null) throw new NullPointerException("Человека не существует");
        List<Human> copyList = new ArrayList<>();
        for (Human temp : list) {
            if (temp == null) throw new NullPointerException("Человека внутри set не существует");
            if (!temp.equals(human)) {
                copyList.add(temp);
            }
        }
        return copyList;
    }

    public static List<Set<Integer>> setWithoutIntersection(List<Set<Integer>> list, Set<Integer> set) { // 4
        if (list == null) throw new NullPointerException("Списка не существует");
        if (set == null) throw new NullPointerException("Множества не существует");
        List<Set<Integer>> newList = new ArrayList<>();
        for (Set<Integer> item : list) {
            if (Collections.disjoint(item,set)){
                newList.add(item);
            }
        }
        return newList;
    }

    public static Set<Human> SetMatchId(Map<Integer, Human> map, Set<Integer> set) { // 7
        if (map == null) throw new NullPointerException("Набора(Map) не существует");
        if (set == null) throw new NullPointerException("Множества не существует");
        Set<Human> newSet = new HashSet<>();
        for (int id : set) {
            if (map.containsKey(id)) {
                if (map.get(id) == null) throw new NullPointerException("Человека внутри map не существует");
                newSet.add(map.get(id));
            }
        }
        return newSet;
    }

    public static List<Integer> ListId(Map<Integer, Human> map) { // 8
        if (map == null) throw new NullPointerException("Набора(Map) не существует");
        List<Integer> list = new ArrayList<>();
        for (int item : map.keySet()) {
            if (map.get(item) == null) throw new NullPointerException("Человека внутри map не существует");
            if (map.get(item).getAge() >= 18) {
                list.add(item);
            }
        }
        return list;
    }

    public static Map<Integer, Integer> MapOfAges(Map<Integer, Human> id) { // 9
        if (id == null) throw new NullPointerException("Набора(Map) не существует");
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : id.keySet()) {
            if (id.get(key) == null) throw new NullPointerException("Человека внутри map не существует");
            map.put(key, id.get(key).getAge());
        }
        return map;
    }

    public static Map<Integer, List<Human>> MapOfAgesLists(Set<Human> set) { // 10
        if (set == null) throw new NullPointerException("Множества не существует");
        Map<Integer, List<Human>> map = new HashMap<>();
        for (Human item : set) {
            if (item == null) throw new NullPointerException("Человека внутри set не существует");
            if (!map.containsKey(item.getAge())) {
                map.put(item.getAge(), new ArrayList<>());
            }
            map.get(item.getAge()).add(item);
        }
        return map;
    }
}



