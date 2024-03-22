package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class ListDemo {
    public static List<Human> familiaList(List<? extends Human> list, Human human) { // 2
        if (list.isEmpty()) throw new NullPointerException("Списка не существует");
        if (human == null) throw new NullPointerException("Человека не существует");
        List<Human> newList = new ArrayList();
        for (Human temp : list) {
            if (temp == null) throw new NullPointerException("Человека внутри list не существует");
            if (temp.getFamilia().equals(human.getFamilia())) {
                newList.add(temp);
            }
        }
        return newList;
    }

    public static Set<Human> setHumanMaxAge(List<? extends Human> list) { // 5
        if (list == null) throw new NullPointerException("Списка не существует");
        int maxAge = 0;
        Set<Human> set = new HashSet<>();
        for (Human item : list) {
            if (item == null) throw new NullPointerException("Человека внутри list не существует");
            if (item.getAge() > maxAge) maxAge = item.getAge();
        }
        for (Human item : list) {
            if (item.getAge() == maxAge) set.add(item);
        }
        return set;
    }

}

