package com.niketest.factories;

import com.niketest.interfaces.WindowFinderStrategy;
import com.niketest.strategies.SlidingWindowFinderStrategy;

public class WindowFinderFactory {
    public static WindowFinderStrategy getSlidingWindowFinderStrategy() {
        return new SlidingWindowFinderStrategy();
    }
}