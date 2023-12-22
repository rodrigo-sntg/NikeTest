package com.niketest.decorator;

import com.niketest.decorators.CachingWindowFinderDecorator;
import com.niketest.strategies.WindowFinderStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CachingWindowFinderDecoratorTest {

    @Mock
    private WindowFinderStrategy mockStrategy;

    private CachingWindowFinderDecorator decorator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        decorator = new CachingWindowFinderDecorator(mockStrategy);
    }

    @Test
    public void testCaching() {
        String input = "this is a test string";
        String pattern = "tist";
        String expected = "t stri";

        when(mockStrategy.findSmallestWindow(input, pattern)).thenReturn(expected);
        
        // First call - should use the strategy
        assertEquals(expected, decorator.findSmallestWindow(input, pattern));

        // Second call - should use the cache and not call the strategy again
        assertEquals(expected, decorator.findSmallestWindow(input, pattern));
        verify(mockStrategy, times(1)).findSmallestWindow(input, pattern);
    }
}
