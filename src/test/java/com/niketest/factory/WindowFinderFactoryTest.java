package com.niketest.factory;

import com.niketest.factories.WindowFinderFactory;
import com.niketest.strategies.SlidingWindowFinderStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WindowFinderFactoryTest {

    @Test
    public void testGetSlidingWindowFinderStrategy() {
        assertTrue(WindowFinderFactory.getSlidingWindowFinderStrategy() instanceof SlidingWindowFinderStrategy);
    }
}
