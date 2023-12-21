package com.niketest.decorators;

import com.niketest.interfaces.WindowFinderStrategy;

/**
 * Decorator base class for WindowFinderStrategy.
 * This class serves as a decorator for WindowFinderStrategy implementations.
 * It can be extended to add additional functionalities like caching
 * to the existing strategy implementations.
 */
abstract class WindowFinderDecorator implements WindowFinderStrategy {
    protected WindowFinderStrategy decoratedFinder;

    public WindowFinderDecorator(WindowFinderStrategy decoratedFinder) {
        this.decoratedFinder = decoratedFinder;
    }

    /**
     * Delegates the call to the decorated WindowFinderStrategy's findSmallestWindow method.
     * This method can be overridden in subclasses to add additional behaviors.
     *
     * @param input The string in which to find the smallest window.
     * @param pattern The pattern containing characters to be included in the window.
     * @return The smallest substring of input that contains all characters of the pattern.
     */
    @Override
    public String findSmallestWindow(String input, String pattern) {
        return decoratedFinder.findSmallestWindow(input, pattern);
    }
}