package com.niketest.interfaces;
/**
 * Interface for strategies used in finding the smallest window substring.
 * This interface defines a contract for implementing various algorithms
 * to find the smallest substring within a given string that contains all
 * characters of another string.
 */
public interface WindowFinderStrategy {

    /**
     * Finds the smallest window in the given input string that contains all characters
     * of the specified pattern. Implementations of this method will provide different
     * algorithms to perform this search.
     *
     * @param input The string in which to find the smallest window.
     * @param pattern The pattern containing characters to be included in the window.
     * @return The smallest substring of input that contains all characters of the pattern.
     */
    String findSmallestWindow(String input, String pattern);
}
