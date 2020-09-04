package com.hehe.Classic;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU01 {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache<>(3);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        System.out.println(lru.get(1));
        lru.put(4,4);

        System.out.println(lru.get(2));
        System.out.println(lru.get(3));

    }
    // 继承LinkedHashMap
    public static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int MAX_CACHE_SIZE;

        public LRUCache(int cacheSize) {
            // 使用构造方法 public LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
            // initialCapacity、loadFactor都不重要
            // accessOrder要设置为true，按访问排序
            super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
            MAX_CACHE_SIZE = cacheSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            // 超过阈值时返回true，进行LRU淘汰
            return size() > MAX_CACHE_SIZE;
        }

    }
//
//    public static class LRUCache<K,V> extends LinkedHashMap<K,V>{
//
//    }
}
