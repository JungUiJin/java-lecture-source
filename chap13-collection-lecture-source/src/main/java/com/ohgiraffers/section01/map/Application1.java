package com.ohgiraffers.section01.map;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {

        HashMap map = new HashMap();

        /* 키와 값을 쌍으로 저장한다. 키와 값은 반드시 객체여야 한다. */
        map.put("key1", new Date());
        map.put(12, "red apple");
        map.put(33,123);

        System.out.println(map);

        /* 키값은 중복 저장할 수 없다. 새로운 값으로 덮어쓰기 된다. */
        map.put(12, "yellow banana");
        System.out.println(map);

        /* 값 객체는 중복 저장 할 수 있다. */
        map.put(9, "yellow banana");
        System.out.println(map);

        /* 값 객체를 가져올 때 키를 통해 가져온다. */
        System.out.println("key 9에 대한 값 : " + map.get(9));

        /* 키를 통해 값을 삭제한다. */
        map.remove(9);
        System.out.println(map);

        /* 문자열 키, 값을 가지는 HashMap 생성 */
        HashMap<String, String> map2 = new HashMap();

        map2.put("key1", "red apple");
        map2.put("key2", "yellow banana");
        map2.put("key3", "orange orange");
        map2.put("key4", "green avocado");

        System.out.println(map2);

        /* map 에 저장된 값을 순회하는 방법
        * 1. ketSet() */
        Iterator<String> it = map2.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            Object value = map2.get(key);
            System.out.println(key + ":" + value);
        }

        for (String key : map2.keySet()) {
            Object value = map2.get(key);
            System.out.println(key + ":" + value);
        }
        System.out.println();

        /* 2. values() */
        Collection<String> values = map2.values();
        Iterator<String> it2 = values.iterator();
        while (it2.hasNext()) {
            String key = it2.next();
            System.out.println(key + ":" + map2.get(key));
        }

        for (String key : map2.keySet()) {
            System.out.println(key + ":" + map2.get(key));
        }

        /* 3. entrySet() */
        Set<Map .Entry<String,String>> set = map2.entrySet();

        Iterator<Map .Entry<String,String>> setIter = set.iterator();
        while (setIter.hasNext()) {
            Map.Entry<String,String> entry = setIter.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        for (Map.Entry<String, String> entry : set) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}
