# TDD Algorithms & Data Structures

A **Test-Driven Development (TDD)** repository focused on solving LeetCode's "Blind 75" problems using Java 21 and Spring Boot.

## What is TDD (Test-Driven Development)?

**Test-Driven Development (TDD)** is a software development methodology where tests are written *before* the actual implementation code. The TDD cycle follows three simple steps:

### The TDD Cycle: Red-Green-Refactor

1. **Red** - Write a failing test
   - Write a test for the next bit of functionality you want to add
   - Run the test and watch it fail (since the code doesn't exist yet)

2. **Green** - Make the test pass
   - Write the minimum amount of code needed to make the test pass
   - Don't worry about perfection, just make it work

3. **Refactor** - Improve the code
   - Clean up the code while keeping tests green
   - Optimize, remove duplication, improve readability

### Benefits of TDD

- **Better Code Quality**: Forces you to think about requirements before coding
- **Built-in Documentation**: Tests serve as living documentation of how code should work
- **Confidence in Changes**: Comprehensive tests catch regressions early
- **Simpler Design**: Writing tests first leads to more modular, testable code
- **Fewer Bugs**: Issues are caught during development, not in production
- **Learning Tool**: Great for understanding algorithms by defining expected behavior first

---

## Repository Overview

**Language:** Java 21 (with preview features)
**Framework:** Spring Boot 3.5.6
**Build Tool:** Maven
**Testing Framework:** JUnit 5 (Jupiter)
**Focus:** LeetCode Blind 75 Problems

---

## Project Structure

```
TDD-algorithms-ds/
├── src/
│   ├── main/java/com/microservices/test/
│   │   ├── blind75/              # Algorithm implementations
│   │   │   ├── TwoSum.java
│   │   │   ├── ContainDuplicate.java
│   │   │   ├── ValidParentheses.java
│   │   │   ├── ValidAnagram.java
│   │   │   ├── BestTimeToBuyAndSellStocks.java
│   │   │   └── MaximumSumSubarray.java
│   │   └── arrays/easy/          # Future algorithm categories
│   └── test/java/com/microservices/test/blind75/
│       ├── TwoSumTest.java
│       ├── ContainDuplicateTest.java
│       ├── ValidParenthesesTest.java
│       ├── ValidAnagramTest.java
│       ├── BestTimeToBuyAndSellStocksTest.java
│       └── MaximumSumSubarrayTest.java
├── pom.xml                       # Maven configuration
└── README.md
```

---

## Implemented Problems (6/75)

### Arrays & Hashing

| Problem | Difficulty | Algorithm/Technique | Time Complexity |
|---------|-----------|---------------------|-----------------|
| Two Sum | Easy | HashMap | O(n) |
| Contains Duplicate | Easy | HashSet / Sorting | O(n) / O(n log n) |
| Valid Anagram | Easy | HashSet | O(n) |
| Maximum Subarray (Kadane's) | Medium | Dynamic Programming | O(n) |

### Stack

| Problem | Difficulty | Algorithm/Technique | Time Complexity |
|---------|-----------|---------------------|-----------------|
| Valid Parentheses | Easy | Stack | O(n) |

### Dynamic Programming

| Problem | Difficulty | Algorithm/Technique | Time Complexity |
|---------|-----------|---------------------|-----------------|
| Best Time to Buy/Sell Stock | Easy | DP - Track Min Price | O(n) |

---

## Problem Implementations

### 1. Two Sum
**Problem:** Find two indices in an array that add up to a target sum.
- **Approach:** HashMap for O(n) lookup of complements
- **Test Coverage:** 16+ test cases including edge cases

### 2. Contains Duplicate
**Problem:** Detect if array contains any duplicate elements.
- **Approach 1:** Sorted array comparison
- **Approach 2:** HashSet membership check (optimal)
- **Test Coverage:** Edge cases, performance verification

### 3. Valid Parentheses
**Problem:** Validate if parentheses/brackets are balanced.
- **Approach:** Stack-based matching
- **Supports:** `()`, `[]`, `{}`
- **Test Coverage:** Nested brackets, mismatched cases

### 4. Valid Anagram
**Problem:** Check if two strings are anagrams of each other.
- **Approach:** Character frequency tracking with HashSet
- **Test Coverage:** Case sensitivity, empty strings, special characters

### 5. Best Time to Buy and Sell Stock
**Problem:** Find maximum profit from single buy/sell transaction.
- **Approach:** Track minimum price while calculating max profit
- **Test Coverage:** Decreasing prices, multiple peaks

### 6. Maximum Subarray (Kadane's Algorithm)
**Problem:** Find contiguous subarray with maximum sum.
- **Approach:** Kadane's algorithm (in progress)
- **Test Coverage:** Negative numbers, mixed arrays

---

## Testing Approach

This repository emphasizes **comprehensive test coverage** using JUnit 5 and follows the **Arrange-Act-Assert (AAA)** pattern for writing clean, maintainable unit tests.

### Arrange-Act-Assert Pattern

The **AAA pattern** is a widely-used structure for writing unit tests that makes tests easy to read and understand. Every test is divided into three distinct sections:

#### 1. Arrange (Setup)
Set up the test data, objects, and preconditions needed for the test.
- Initialize input data
- Create mock objects or test doubles
- Configure the system under test
- Set expectations

#### 2. Act (Execute)
Execute the code being tested.
- Call the method or function
- Trigger the behavior
- Perform a single action (keep it focused!)

#### 3. Assert (Verify)
Verify that the expected behavior occurred.
- Check return values
- Verify state changes
- Confirm expected exceptions
- Validate side effects

### AAA Pattern Benefits

- **Readability**: Clear separation makes tests easy to understand
- **Maintainability**: Structured approach simplifies updates
- **Consistency**: Team members follow the same pattern
- **Focus**: Each section has a single responsibility
- **Debugging**: Easy to identify which phase is failing

### AAA Pattern in Practice

#### Example 1: Basic Two Sum Test

```java
@Test
@DisplayName("Should find two indices that sum to target")
void testTwoSum_BasicCase() {
    // Arrange - Set up test data
    int[] nums = {2, 7, 11, 15};
    int target = 9;

    // Act - Execute the algorithm
    int[] result = twoSum.solution(nums, target);

    // Assert - Verify the outcome
    assertArrayEquals(new int[]{0, 1}, result);
}
```

#### Example 2: Testing Edge Cases

```java
@Test
@DisplayName("Should return empty array when no solution exists")
void testTwoSum_NoSolution() {
    // Arrange
    int[] nums = {1, 2, 3};
    int target = 10;

    // Act
    int[] result = twoSum.solution(nums, target);

    // Assert
    assertArrayEquals(new int[]{}, result);
}
```

#### Example 3: Testing with Complex Setup

```java
@Test
@DisplayName("Should validate nested parentheses correctly")
void testValidParentheses_NestedBrackets() {
    // Arrange
    String input = "{[()]}";
    ValidParentheses validator = new ValidParentheses();

    // Act
    boolean result = validator.isValid(input);

    // Assert
    assertTrue(result, "Nested brackets should be valid");
}
```

#### Example 4: Testing Exception Handling

```java
@Test
@DisplayName("Should throw exception for null input")
void testTwoSum_NullInput() {
    // Arrange
    int[] nums = null;
    int target = 5;

    // Act & Assert (combined for exception testing)
    assertThrows(IllegalArgumentException.class, () -> {
        twoSum.solution(nums, target);
    });
}
```

### Test Features

- **Parameterized Tests** - Multiple test cases in single test method
- **@DisplayName Annotations** - Human-readable test descriptions
- **@BeforeEach Setup** - Consistent test initialization
- **Edge Case Coverage** - Empty arrays, negatives, duplicates, large numbers
- **Performance Testing** - Algorithm efficiency verification
- **AAA Pattern** - Structured, readable test organization

### Advanced Testing Patterns

#### Parameterized Tests with AAA

```java
@ParameterizedTest
@CsvSource({
    "2,7,11,15, 9, 0,1",
    "3,2,4, 6, 1,2",
    "3,3, 6, 0,1"
})
@DisplayName("Should find correct indices for multiple test cases")
void testTwoSum_MultipleInputs(int num1, int num2, int num3, int num4,
                                 int target, int expectedIdx1, int expectedIdx2) {
    // Arrange
    int[] nums = {num1, num2, num3, num4};
    int[] expected = {expectedIdx1, expectedIdx2};

    // Act
    int[] result = twoSum.solution(nums, target);

    // Assert
    assertArrayEquals(expected, result);
}
```

#### Using @BeforeEach for Arrange Phase

```java
class TwoSumTest {
    private TwoSum twoSum;

    @BeforeEach
    void setUp() {
        // Arrange - Common setup for all tests
        twoSum = new TwoSum();
    }

    @Test
    @DisplayName("Should handle positive numbers")
    void testPositiveNumbers() {
        // Arrange - Test-specific setup
        int[] nums = {1, 2, 3, 4};
        int target = 7;

        // Act
        int[] result = twoSum.solution(nums, target);

        // Assert
        assertArrayEquals(new int[]{2, 3}, result);
    }
}
```

### Testing Best Practices in This Repository

1. **One Assertion Per Concept**: Each test verifies one specific behavior
2. **Descriptive Test Names**: Use `@DisplayName` for clear intent
3. **Independent Tests**: Tests don't depend on each other's execution
4. **Fast Execution**: Tests run quickly for rapid feedback
5. **Deterministic**: Same input always produces same output
6. **Clear AAA Sections**: Sometimes separated by blank lines or comments

### Test Organization

```
test/
└── com/microservices/test/blind75/
    ├── TwoSumTest.java
    │   ├── Basic functionality tests
    │   ├── Edge case tests
    │   ├── Error handling tests
    │   └── Performance tests
    ├── ContainDuplicateTest.java
    └── ... (other test classes)
```

---

## Technology Stack

| Technology | Version | Purpose |
|-----------|---------|---------|
| Java | 21 | Primary development language |
| Spring Boot | 3.5.6 | Application framework |
| Maven | Latest | Build and dependency management |
| JUnit | 5 (Jupiter) | Unit testing framework |

### Maven Configuration

- **Java 21** with preview features enabled
- **Spring Boot Starter Test** for testing utilities
- **Maven Compiler Plugin** configured for modern Java features

---

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Running the Project

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd TDD-algorithms-ds
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run tests**
   ```bash
   mvn test
   ```

4. **Run specific test class**
   ```bash
   mvn test -Dtest=TwoSumTest
   ```

### TDD Workflow Example

1. **Write a failing test** (Red)
   ```java
   @Test
   void testNewAlgorithm() {
       int result = algorithm.solve(input);
       assertEquals(expected, result);
   }
   ```

2. **Implement minimum code** (Green)
   ```java
   public int solve(int[] input) {
       // Implement solution
       return result;
   }
   ```

3. **Refactor and optimize** (Refactor)
   ```java
   // Improve code quality, add documentation
   // All tests still pass
   ```

---

## Development Patterns

- **TDD Methodology**: Tests written before/alongside implementation
- **Algorithm Documentation**: Problem references and approach explanations
- **Multiple Solutions**: Different algorithmic approaches demonstrated
- **Code Organization**: Clear package structure for problem categories
- **Performance Focus**: Tests verify time/space complexity

---

## Progress Tracking

**Completed:** 6/75 (8%)
**In Progress:** Maximum Subarray
**Remaining:** 69 problems

### Blind 75 Categories

- [ ] Arrays & Hashing (6 started)
- [ ] Two Pointers
- [ ] Sliding Window
- [ ] Stack
- [ ] Binary Search
- [ ] Linked List
- [ ] Trees
- [ ] Tries
- [ ] Heap / Priority Queue
- [ ] Backtracking
- [ ] Graphs
- [ ] Advanced Graphs
- [ ] 1-D Dynamic Programming
- [ ] 2-D Dynamic Programming
- [ ] Greedy
- [ ] Intervals
- [ ] Math & Geometry
- [ ] Bit Manipulation

---

## Contributing

This is a learning repository. Feel free to:

- Add new Blind 75 problem solutions
- Improve existing implementations
- Add more comprehensive tests
- Optimize algorithms
- Add documentation and comments

### Code Style

- Follow Java naming conventions
- Write comprehensive tests first (TDD!)
- Include problem description and approach comments
- Add time/space complexity analysis
- Cover edge cases in tests

---

## Resources

- [LeetCode Blind 75](https://leetcode.com/discuss/general-discussion/460599/blind-75-leetcode-questions)
- [DesignGurus Problem Set](https://www.designgurus.io/)
- [NeetCode Solutions](https://neetcode.io/)
- [JUnit 5 Documentation](https://junit.org/junit5/docs/current/user-guide/)

---

## License

This project is for educational purposes.

---

## Author

Built with Test-Driven Development principles to master algorithms and data structures, Hakam

**Happy Coding!** 🚀
