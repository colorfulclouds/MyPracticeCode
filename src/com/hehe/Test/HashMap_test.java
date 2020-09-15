package com.hehe.Test;

import java.util.*;


/**
 * HashMap和linkedHashMap
 */
public class HashMap_test {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap();
        map.put("name1", "josan1");
        map.put("name2", "josan2");
        map.put("name3", "josan3");
        map.put("name4", "josan3");
        map.put("name5", "josan3");
        map.put("name6", "josan3");



        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);

        }
        System.out.println("================================");
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("name1", "josan1");
        linkedHashMap.put("name2", "josan2");
        linkedHashMap.put("name3", "josan3");
        Set<Map.Entry<String, String>> set01 = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator01 = set01.iterator();
        while (iterator01.hasNext()) {
            Map.Entry entry = iterator01.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }
}
