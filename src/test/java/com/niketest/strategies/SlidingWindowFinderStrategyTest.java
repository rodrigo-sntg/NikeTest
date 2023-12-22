package com.niketest.strategies;

import com.niketest.exceptions.InvalidInputException;
import com.niketest.exceptions.PatternLongerThanInputException;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SlidingWindowFinderStrategyTest {

    private final WindowFinderStrategy strategy = new SlidingWindowFinderStrategy();

    @Test
    public void testFindSmallestWindow() {
        String input = "this is a test string";
        String pattern = "tist";
        String expected = "t stri";
        assertEquals(expected, strategy.findSmallestWindow(input, pattern));
    }

    @Test
    public void testNullInputThrowsInvalidInputException() {
        assertThrows(InvalidInputException.class, () -> {
            strategy.findSmallestWindow(null, "pattern");
        });
    }

    @Test
    public void testNullPatternThrowsInvalidInputException() {
        assertThrows(InvalidInputException.class, () -> {
            strategy.findSmallestWindow("input", null);
        });
    }

    @Test
    public void testInputWithAllIdenticalCharacters() {
        String input = "aaaaaaa";
        String pattern = "a";
        String expected = "a";
        assertEquals(expected, strategy.findSmallestWindow(input, pattern));
    }

    @Test
    public void testPatternWithAllIdenticalCharacters() {
        String input = "abcdeafghia";
        String pattern = "aa";
        String expected = "abcdea";
        assertEquals(expected, strategy.findSmallestWindow(input, pattern));
    }

    @Test
    public void testPatternCharactersSpreadAcrossInput() {
        String input = "abcdeafghibjkclmnop";
        String pattern = "akc";
        String expected = "afghibjkc";
        assertEquals(expected, strategy.findSmallestWindow(input, pattern));
    }

    @Test
    public void testInputWithNoMatchingPattern() {
        String input = "abcdefgh";
        String pattern = "xyz";
        String expected = "";
        assertEquals(expected, strategy.findSmallestWindow(input, pattern));
    }

    @Test
    public void testPatternLargerThanInput() {
        String input = "abc";
        String pattern = "abcd";
        assertThrows(PatternLongerThanInputException.class, () -> {
            strategy.findSmallestWindow(input, pattern);
        });
    }

}
