# Smallest Window Substring Finder Project

## Description
This project is about creating a Java program that can find the smallest part of a text (substring) which includes all the letters from another piece of text. We've used some common programming techniques to make sure the code is well-organized, easy to change, and includes checks to catch and handle errors. We also have tests to make sure everything works as expected.

## Getting Started
To run this project, you'll need a Java development environment set up on your machine.

### Prerequisites
- Java JDK
- Git (for cloning the repository)

### Installation
Clone the repository to your local machine:
```bash
git clone https://github.com/rodrigo-sntg/NikeTest
```

## Project Structure
- **Strategies**:
    - `WindowFinderStrategy`: Interface for finding smallest window substring.
    - `SlidingWindowFinderStrategy`: Implementation using sliding window technique.
- **Decorators**:
    - `WindowFinderDecorator`: Base decorator class.
    - `CachingWindowFinderDecorator`: Decorator that adds caching functionality.
- **Factory**:
    - `WindowFinderFactory`: Factory class for creating strategy instances.
- **Singleton**:
    - `CacheSingleton`: Singleton class for caching results.
- **Custom Exceptions**:
    - `InvalidInputException`: Thrown for invalid input scenarios.
    - `PatternLongerThanInputException`: Thrown when the pattern is longer than the input.
    - `StrategyInitializationException`: Thrown during strategy initialization failure.
    - `CacheOperationException`: Thrown for cache operation failures.

## Algorithm Evolution
### Initial Implementation
The first version of the `findSmallestWindow` method attempted to use a queue to track pattern characters in the input string. This approach faced significant challenges:
- **Incomplete Logic**: Lacked complete implementation to check the presence of all pattern characters effectively.
- **Inefficient Window Management**: No mechanism to dynamically adjust the size of the sliding window.

### Improved Implementation
The algorithm was refined to address the initial shortcomings:
- **Effective Character Tracking**: Introduced a `HashMap` for efficiently tracking character frequencies in the pattern.
- **Dynamic Window Sizing**: Implemented two pointers to represent the sliding window, expanding and shrinking it dynamically.
- **Optimized Smallest Window Detection**: The algorithm now accurately finds and returns the smallest possible window.

## Testing
This project uses JUnit and Mockito for unit testing. The tests cover various components and scenarios, ensuring the reliability of the system.

### Running Tests
To run the tests, execute `mvn test` in the project directory.

### Test Classes
- `SlidingWindowFinderStrategyTest`: Tests for the sliding window strategy.
- `SmallestWindowSearcherTest`: Tests for the main searcher functionality.
- `WindowFinderFactoryTest`: Tests for the strategy factory.
- `CachingWindowFinderDecoratorTest`: Tests for the caching decorator.
- `CacheSingletonTest`: Tests for the caching singleton.

## Error Handling
The project includes custom exceptions to handle specific error conditions gracefully and clearly.