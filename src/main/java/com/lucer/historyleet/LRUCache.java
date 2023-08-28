package com.lucer.historyleet;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * lru缓存
 * https://leetcode-cn.com/problems/lru-cache-lcci/
 *
 * @author: liuchuan
 */
public class LRUCache<String, Object> extends LinkedHashMap<String, Object> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }


    // return -1
    public Object get(int k) {
        return super.getOrDefault(k, null);
    }

    @Override
    public Object put(String key, Object value) {
        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
        return size() > capacity;
    }
}
