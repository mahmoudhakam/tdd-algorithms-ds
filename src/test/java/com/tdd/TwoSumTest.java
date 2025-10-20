package com.tdd;

import com.tdd.blind75.TwoSum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TwoSum Algorithm Tests")
class TwoSumTest {

    private TwoSum twoSum;

    @BeforeEach
    void setUp() {
        twoSum = new TwoSum();
    }

    @Test
    @DisplayName("Given basic array, when array={3, 2, 4} and target=6, then result={1,2}")
    void givenBasicArray_whenPositiveNumbers_thenReturn() {
        int[] arr = {3, 2, 4};
        int[] expectedArray = {1, 2};
        int target = 6;

        int[] result = twoSum.twoSum(arr, target);

        assertNotNull(result);
        assertArrayEquals(expectedArray, result);
    }


    @Test
    @DisplayName("Given array with negative numbers, when array={-1, -2, -3, -4, -5} and target=-8, then result={2,4}")
    void givenArrayWithNegativeNumbers() {
        int[] arr = {-1, -2, -3, -4, -5};
        int[] expectedResult = {2, 4};
        int target = -8;

        int[] result = twoSum.twoSum(arr, target);

        assertNotNull(result);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Should find two numbers that sum to target - Basic case")
    void testTwoSumBasicCase() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.twoSum(nums, target);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    @Test
    @DisplayName("Should find two numbers that sum to target - Different positions")
    void testTwoSumDifferentPositions() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum.twoSum(nums, target);

        assertNotNull(result);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    @Test
    @DisplayName("Should handle array with same number appearing twice")
    void testTwoSumWithDuplicates() {
        int[] nums = {3, 3};
        int target = 6;
        int[] result = twoSum.twoSum(nums, target);

        assertNotNull(result);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    @Test
    @DisplayName("Should handle negative numbers")
    void testTwoSumWithNegativeNumbers() {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;
        int[] result = twoSum.twoSum(nums, target);

        assertNotNull(result);
        assertEquals(2, result[0]);
        assertEquals(4, result[1]);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    @Test
    @DisplayName("Should handle mix of positive and negative numbers")
    void testTwoSumWithMixedNumbers() {
        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        int[] result = twoSum.twoSum(nums, target);

        assertNotNull(result);
        assertEquals(0, result[0]);
        assertEquals(2, result[1]);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    @Test
    @DisplayName("Should return [-1, -1] when no solution exists")
    void testTwoSumNoSolution() {
        int[] nums = {1, 2, 3, 4};
        int target = 10;
        int[] result = twoSum.twoSum(nums, target);

        assertNotNull(result);
        assertEquals(2, result.length);
        assertArrayEquals(new int[]{-1, -1}, result);
    }

    @Test
    @DisplayName("Should handle minimum array size")
    void testTwoSumMinimumArray() {
        int[] nums = {1, 2};
        int target = 3;
        int[] result = twoSum.twoSum(nums, target);

        assertNotNull(result);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    @DisplayName("Should handle large numbers")
    void testTwoSumWithLargeNumbers() {
        int[] nums = {1000000, 2000000, 3000000};
        int target = 5000000;
        int[] result = twoSum.twoSum(nums, target);

        assertNotNull(result);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    @Test
    @DisplayName("Should handle zero values")
    void testTwoSumWithZeros() {
        int[] nums = {0, 4, 3, 0};
        int target = 0;
        int[] result = twoSum.twoSum(nums, target);

        assertNotNull(result);
        assertEquals(0, result[0]);
        assertEquals(3, result[1]);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    @Test
    @DisplayName("Should find first valid pair when multiple solutions exist")
    void testTwoSumMultipleSolutions() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 6;
        int[] result = twoSum.twoSum(nums, target);

        assertNotNull(result);
        assertEquals(2, result.length);
        // Should return the first valid pair found
        assertEquals(target, nums[result[0]] + nums[result[1]]);
        assertTrue(result[0] < result[1], "First index should be less than second index");
    }

    @Test
    @DisplayName("Should handle array with target at the end")
    void testTwoSumTargetAtEnd() {
        int[] nums = {15, 11, 2, 7};
        int target = 9;
        int[] result = twoSum.twoSum(nums, target);

        assertNotNull(result);
        assertEquals(2, result[0]);
        assertEquals(3, result[1]);
    }

    // Parameterized tests for multiple test cases
    @ParameterizedTest
    @MethodSource("provideTwoSumTestCases")
    @DisplayName("Parameterized test for various inputs")
    void testTwoSumParameterized(int[] nums, int target, int[] expected) {
        int[] result = twoSum.twoSum(nums, target);

        assertNotNull(result);
        assertEquals(2, result.length);

        if (expected[0] == -1 && expected[1] == -1) {
            assertArrayEquals(expected, result);
        } else {
            assertEquals(target, nums[result[0]] + nums[result[1]]);
        }
    }

    private static Stream<Arguments> provideTwoSumTestCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),
                Arguments.of(new int[]{1, 2, 3}, 10, new int[]{-1, -1}),
                Arguments.of(new int[]{-1, -2, -3, -4}, -6, new int[]{1, 3}),
                Arguments.of(new int[]{0, 4, 3, 0}, 0, new int[]{0, 3})
        );
    }

//    @Test
//    @DisplayName("Should verify time complexity - Performance test")
//    void testTwoSumPerformance() {
//        // Create a large array
//        int size = 10000;
//        int[] nums = new int[size];
//        for (int i = 0; i < size; i++) {
//            nums[i] = i;
//        }
//        int target = size - 1;
//
//        long startTime = System.nanoTime();
//        int[] result = twoSum.twoSum(nums, target);
//        long endTime = System.nanoTime();
//
//        assertNotNull(result);
//        long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
//        assertTrue(duration < 100, "Algorithm should complete in less than 100ms for 10k elements");
//    }

    @Test
    @DisplayName("Should handle single element array - Edge case")
    void testTwoSumSingleElement() {
        int[] nums = {5};
        int target = 10;
        int[] result = twoSum.twoSum(nums, target);

        assertNotNull(result);
        assertArrayEquals(new int[]{-1, -1}, result);
    }

    @Test
    @DisplayName("Should verify indices are in correct order")
    void testTwoSumIndicesOrder() {
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        int[] result = twoSum.twoSum(nums, target);

        assertNotNull(result);
        assertTrue(result[0] < result[1],
                "First index should be less than second index");
    }
}