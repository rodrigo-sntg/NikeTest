package com.niketest.searcher;

import com.niketest.SmallestWindowSearcher;
import com.niketest.exceptions.InvalidInputException;
import com.niketest.exceptions.StrategyInitializationException;
import com.niketest.strategies.SlidingWindowFinderStrategy;
import com.niketest.strategies.WindowFinderStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SmallestWindowSearcherTest {

    WindowFinderStrategy mockStrategy = mock(SlidingWindowFinderStrategy.class);
    private final SmallestWindowSearcher searcher = new SmallestWindowSearcher(mockStrategy);



    @Test
    public void testFindSmallestWindow() {
        WindowFinderStrategy mockStrategy = mock(SlidingWindowFinderStrategy.class);

        // Configure the mock to return "t stri" when findSmallestWindow is called with specific parameters
        when(mockStrategy.findSmallestWindow("this is a test string", "tist")).thenReturn("t stri");

        // Use the mock in the searcher
        SmallestWindowSearcher searcher = new SmallestWindowSearcher(mockStrategy);

        // Call the method under test
        String result = searcher.findSmallestWindow("this is a test string", "tist");

        // Assert that the result is as expected
        assertEquals("t stri", result);
    }

    @Test
    public void testNullStrategyThrowsIllegalArgumentException() {
        assertThrows(StrategyInitializationException.class, () -> {
            new SmallestWindowSearcher(null);
        });
    }

    @Test
    public void testInvalidInputThrowsException() {
        WindowFinderStrategy mockStrategy = mock(SlidingWindowFinderStrategy.class);
        when(mockStrategy.findSmallestWindow(null, "pattern")).thenThrow(new InvalidInputException("Invalid input"));

        SmallestWindowSearcher searcher = new SmallestWindowSearcher(mockStrategy);

        assertThrows(InvalidInputException.class, () -> {
            searcher.findSmallestWindow(null, "pattern");
        });
    }
    @Test
    public void testEmptyInputReturnsEmptyString() {
        when(mockStrategy.findSmallestWindow("", "pattern")).thenReturn("");
        assertEquals("", searcher.findSmallestWindow("", "pattern"));
    }

    @Test
    public void testEmptyPatternReturnsEmptyString() {
        when(mockStrategy.findSmallestWindow("input", "")).thenReturn("");
        assertEquals("", searcher.findSmallestWindow("input", ""));
    }

    @Test
    public void testPatternNotFoundReturnsEmptyString() {
        String input = "teststring";
        String pattern = "xyz";
        when(mockStrategy.findSmallestWindow(input, pattern)).thenReturn("");
        assertEquals("", searcher.findSmallestWindow(input, pattern));
    }

    @Test
    public void testLargeInputAndPattern() {
        String input = "a".repeat(10000) + "b";
        String pattern = "ab";
        String expected = "ab";
        when(mockStrategy.findSmallestWindow(input, pattern)).thenReturn(expected);
        assertEquals(expected, searcher.findSmallestWindow(input, pattern));
    }

    @Test
    public void testPatternSameAsInput() {
        String input = "exact";
        String pattern = "exact";
        when(mockStrategy.findSmallestWindow(input, pattern)).thenReturn(input);
        assertEquals(input, searcher.findSmallestWindow(input, pattern));
    }

    @Test
    public void testNonOverlappingCharacters() {
        String input = "abcd";
        String pattern = "efgh";
        when(mockStrategy.findSmallestWindow(input, pattern)).thenReturn("");
        assertEquals("", searcher.findSmallestWindow(input, pattern));
    }
}
