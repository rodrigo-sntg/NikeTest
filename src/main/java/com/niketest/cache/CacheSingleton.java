package com.niketest.cache;

import com.niketest.exceptions.CacheOperationException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheSingleton {
    private static CacheSingleton instance;
    private final Map<String, String> cache;

    private CacheSingleton() {
        cache = new ConcurrentHashMap<>();
    }

    public static synchronized CacheSingleton getInstance() {
        if (instance == null) {
            instance = new CacheSingleton();
        }
        return instance;
    }

    public synchronized String getFromCache(String key) {
        return cache.get(key);
    }

    public synchronized void addToCache(String key, String value) {
        if (key == null || value == null) {
            throw new CacheOperationException("Key and value must not be null");
        }
        cache.put(key, value);
    }
}
