package com.carson.algorithm.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用LinkedHashMap实现LRU
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    //最大entry数量
    private int maxEntries;

    public LRUCache(int maxEntries){
        //构建对象的时候，需要把父类按访问顺序实现
        super(16, 0.75f, true);
        this.maxEntries = maxEntries;
    }

    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size()>maxEntries;
    }

    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<String, String>(3);
        lruCache.put("a", "a");
        lruCache.put("b", "b");
        lruCache.put("c", "c");
        lruCache.get("a");
        lruCache.put("d", "d");
        System.out.println(lruCache);
    }
}
