package com.niketest.factories;

import com.niketest.strategies.WindowFinderStrategy;
import com.niketest.strategies.SlidingWindowFinderStrategy;

/**
 * Factory class for creating instances of WindowFinderStrategy.
 * This class provides factory methods to instantiate different strategies
 * for finding the smallest window substring. It encapsulates the instantiation logic
 * and allows for easy extension of new strategies.
 */
public class WindowFinderFactory {
    /**
     * Creates and returns an instance of SlidingWindowFinderStrategy.
     * This method provides an easy way to instantiate SlidingWindowFinderStrategy,
     * which is a specific implementation of the WindowFinderStrategy interface.
     *
     * @return An instance of SlidingWindowFinderStrategy.
     */
    public static WindowFinderStrategy getSlidingWindowFinderStrategy() {
        return new SlidingWindowFinderStrategy();
    }
}