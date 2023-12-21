package com.niketest;

import com.niketest.factories.WindowFinderFactory;
import com.niketest.interfaces.WindowFinderStrategy;

/**
 * Client class that uses a specified WindowFinderStrategy to find the smallest window substring.
 * This class demonstrates the use of the Strategy pattern, allowing different strategies to be
 * used interchangeably for finding the smallest window in a string.
 */
public class SmallestWindowSearcher {
    private WindowFinderStrategy strategy;

    /**
     * Constructs a SmallestWindowSearcher with a specific WindowFinderStrategy.
     *
     * @param strategy The strategy to be used for finding the smallest window substring.
     */
    public SmallestWindowSearcher(WindowFinderStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Finds the smallest window substring in the given input string that contains all characters
     * of the specified pattern, using the configured WindowFinderStrategy.
     *
     * @param input The string in which to find the smallest window.
     * @param pattern The string containing the characters to be included in the window.
     * @return The smallest substring of 'input' that contains all characters of 'pattern'.
     */
    public String findSmallestWindow(String input, String pattern) {
        return strategy.findSmallestWindow(input, pattern);
    }

    public static void main(String[] args) {
        WindowFinderStrategy strategy = WindowFinderFactory.getSlidingWindowFinderStrategy();
        SmallestWindowSearcher searcher = new SmallestWindowSearcher(strategy);
        String input = "this is a test string";
        String pattern = "tist";
        String result = searcher.findSmallestWindow(input, pattern);
        System.out.println("The smallest window is: " + result);
    }
}