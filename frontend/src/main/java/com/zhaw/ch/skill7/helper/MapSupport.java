package com.zhaw.ch.skill7.helper;

import java.util.*;

public class MapSupport {

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> unsortMap) {
        List<Map.Entry<K, V>> list = new LinkedList<>(unsortMap.entrySet());

        list.sort(Comparator.comparing(Map.Entry::getValue));

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;

    }
}
