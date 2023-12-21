package com.niketest.strategies;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import com.niketest.interfaces.*;
public class SlidingWindowFinderStrategy implements WindowFinderStrategy {
    @Override
    public String findSmallestWindow(String input, String pattern) {
        if (pattern.length() > input.length()) {
            return "";
        }

        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        int start = 0, matched = 0, minLength = input.length() + 1, subStrStart = 0;
        Queue<Integer> indexQueue = new LinkedList<>();

        for (int end = 0; end < input.length(); end++) {
            char currentChar = input.charAt(end);
            if (charFrequencyMap.containsKey(currentChar)) {
                charFrequencyMap.put(currentChar, charFrequencyMap.get(currentChar) - 1);
                if (charFrequencyMap.get(currentChar) >= 0) {
                    matched++;
                }
                indexQueue.add(end);
            }

            while (matched == pattern.length()) {
                int index = indexQueue.poll();
                char startChar = input.charAt(index);
                if (end - index + 1 < minLength) {
                    minLength = end - index + 1;
                    subStrStart = index;
                }
                charFrequencyMap.put(startChar, charFrequencyMap.get(startChar) + 1);
                if (charFrequencyMap.get(startChar) > 0) {
                    matched--;
                }
            }
        }

        return minLength > input.length() ? "" : input.substring(subStrStart, subStrStart + minLength);
    }
}