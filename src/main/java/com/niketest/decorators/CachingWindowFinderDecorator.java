package com.niketest.decorators;

import com.niketest.cache.CacheSingleton;
import com.niketest.interfaces.WindowFinderStrategy;

// Decorator Concreto para Caching
class CachingWindowFinderDecorator extends WindowFinderDecorator {
    public CachingWindowFinderDecorator(WindowFinderStrategy decoratedFinder) {
        super(decoratedFinder);
    }

    /**
     * Decorator method that finds the smallest window in the input string containing all characters of the pattern.
     * This implementation acts as a decorator to enhance the underlying strategy pattern. It introduces a caching mechanism
     * to store and retrieve previously computed results, this way optimizing performance for repeated searches with the same input and pattern.
     * If a cached result is available, it's returned directly to avoid re-computation. Otherwise, it delegates the computation to the
     * encapsulated strategy instance and then caches the result.
     *
     * @param input The string in which to find the smallest window.
     * @param pattern The pattern containing characters to be included in the window.
     * @return The smallest substring of the input that contains all characters of the pattern. Returns a cached result if available.
     */
    @Override
    public String findSmallestWindow(String input, String pattern) {
        CacheSingleton cache = CacheSingleton.getInstance(); // Acessa o cache Singleton
        String cacheKey = input + "|" + pattern;

        String cachedResult = cache.getFromCache(cacheKey);
        if (cachedResult != null) {
            System.out.println("Cache hit for key: " + cacheKey);
            return cachedResult;
        }

        String result = super.findSmallestWindow(input, pattern);
        cache.addToCache(cacheKey, result);
        return result;
    }
}