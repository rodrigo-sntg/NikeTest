package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String input = "this is a test string";
        String pattern = "tist";

        System.out.println(findSmallestWindow2(input, pattern));
    }

    public static String findSmallestWindow(String input, String pattern){

        if (pattern.length() > input.length()) {
            return "";
        }

        String output = "";

        Queue queue = new LinkedList<Character>();

        for(char patternChar : pattern.toCharArray()){
            queue.add(Character.valueOf(patternChar));
        }

        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        char[] patternCharArray = pattern.toCharArray();

        StringBuilder sb = new StringBuilder();

        boolean containsAllChars = false;
        int index = 0;
        while(!containsAllChars){

            sb.append(input.charAt(index));

            if(sb.toString().length() >= patternCharArray.length){
                containsAllChars = true;
//                while(!queue.)
                    //char charValue = queue.pop();
                    //if(!sb.toString().contains(charValue)){
//                        containsAllChars = false;
  //                  }
                }
//            index++;
        }

        return output;
    }


    public static String findSmallestWindow2(String input, String pattern){
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
                // Decrement the frequency of the matched character
                charFrequencyMap.put(currentChar, charFrequencyMap.get(currentChar) - 1);

                if (charFrequencyMap.get(currentChar) >= 0) { // Count every matching of a character
                    matched++;
                }

                indexQueue.add(end);
            }

            // Shrink the window if we can, finish as soon as we remove a matched character
            while (matched == pattern.length()) {
                int index = indexQueue.poll(); // get the start index of the window
                char startChar = input.charAt(index);

                if (end - index + 1 < minLength) {
                    minLength = end - index + 1;
                    subStrStart = index;
                }

                // Put the character back for matching, as we are sliding the window
                charFrequencyMap.put(startChar, charFrequencyMap.get(startChar) + 1);
                if (charFrequencyMap.get(startChar) > 0) {
                    matched--;
                }
            }
        }

        return minLength > input.length() ? "" : input.substring(subStrStart, subStrStart + minLength);
    }
}