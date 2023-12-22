package com.niketest.singleton;

import com.niketest.cache.CacheSingleton;
import com.niketest.exceptions.CacheOperationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CacheSingletonTest {

    private CacheSingleton cache;

    @BeforeEach
    public void setUp() {
        // Since it's a singleton, you always get the same instance
        cache = CacheSingleton.getInstance();
    }

    @Test
    public void testSingletonInstance() {
        // Test if the same instance is returned every time
        CacheSingleton anotherInstance = CacheSingleton.getInstance();
        assertSame(cache, anotherInstance, "Both instances should be the same");
    }

    @Test
    public void testCachingFunctionality() {
        String testKey = "key";
        String testValue = "value";

        // Initially, the cache should not contain the key
        String initialValue = cache.getFromCache(testKey);
        assertEquals(null, initialValue, "Cache should return null for a non-existent key");

        // Add a value to the cache
        cache.addToCache(testKey, testValue);

        // Now the cache should return the value for the key
        String cachedValue = cache.getFromCache(testKey);
        assertEquals(testValue, cachedValue, "Cache should return the value that was added");
    }

    @Test
    public void testAddNullKeyThrowsCacheOperationException() {
        assertThrows(CacheOperationException.class, () -> {
            cache.addToCache(null, "value");
        });
    }

    @Test
    public void testAddNullValueThrowsCacheOperationException() {
        assertThrows(CacheOperationException.class, () -> {
            cache.addToCache("key", null);
        });
    }
}
