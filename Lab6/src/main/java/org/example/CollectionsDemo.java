package org.example;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
    }

    public static int countFirstChar(List<String> list, char symbol) {
        if (list == null) throw new NullPointerException("Списка не существует");
        int count = 0;
        for (String temp : list) {
            if (temp.charAt(0) == symbol) count++;
        }
        return count;
    }

    public static List<Human> copyWithoutHuman(List<Human> list, Human human) {
        if (list == null) throw new NullPointerException("Списка не существует");
        if (human == null) throw new NullPointerException("Человека не существует");
        List<Human> copyList = new ArrayList<>();
        for (Human temp : list) {
            if (temp == null) throw new NullPointerException("Человека внутри set не существует");
            if (!temp.equals(human)) {
                copyList.add(new Human(temp.getFamilia(), temp.getName(), temp.getOtchestvo(), temp.getAge()));
            }
        }
        return copyList;
    }

    public static List<HashSet<Integer>> setWithoutIntersection(List<HashSet<Integer>> list, HashSet<Integer> set) {
        if (list == null) throw new NullPointerException("Списка не существует");
        if (set == null) throw new NullPointerException("Множества не существует");
        List<HashSet<Integer>> newList = new ArrayList<>();
        HashSet<Integer> temp = new HashSet<>();
        try {
            for (HashSet<Integer> item : list) {
                temp.addAll(item);
                temp.retainAll(set);
                if (temp.isEmpty()) {
                    newList.add(item);
                }
                temp.removeAll(item);
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Множества  внутри списка не существует");
        }
        return newList;
    }

    public static HashSet<Human> SetMatchId(Map<Integer, Human> id, Set<Integer> set) {
        if (id == null) throw new NullPointerException("Набора(Map) не существует");
        if (set == null) throw new NullPointerException("Множества не существует");
        HashSet<Human> newSet = new HashSet<>();
        for (int item : set) {
            if (id.containsKey(item)) {
                if (id.get(item) == null) throw new NullPointerException("Человека внутри map не существует");
                newSet.add(id.get(item));
            }
        }
        return newSet;
    }

    public static List<Integer> ListId(Map<Integer, Human> id) {
        if (id == null) throw new NullPointerException("Набора(Map) не существует");
        List<Integer> list = new ArrayList<>();
        for (int item : id.keySet()) {
            if (id.get(item) == null) throw new NullPointerException("Человека внутри map не существует");
            if (id.get(item).getAge() <= 18) {
                list.add(item);
            }
        }
        return list;
    }

    public static Map<Integer, Integer> MapOfAges(Map<Integer, Human> id) {
        if (id == null) throw new NullPointerException("Набора(Map) не существует");
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : id.keySet()) {
            if (id.get(key) == null) throw new NullPointerException("Человека внутри map не существует");
            map.put(key, id.get(key).getAge());
        }
        return map;
    }

    public static Map<Integer, List<Human>> MapOfAgesLists(Set<Human> set) {
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



