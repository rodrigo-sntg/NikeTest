package com.niketest;

import com.niketest.factories.WindowFinderFactory;
import com.niketest.interfaces.WindowFinderStrategy;

public class SmallestWindowSearcher {
    private WindowFinderStrategy strategy;

    public SmallestWindowSearcher(WindowFinderStrategy strategy) {
        this.strategy = strategy;
    }

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