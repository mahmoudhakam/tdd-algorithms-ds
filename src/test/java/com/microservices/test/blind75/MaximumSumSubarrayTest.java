package com.microservices.test.blind75;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSumSubarrayTest {

    MaximumSumSubarray ms;

    @BeforeEach
    void setUp() {
        ms = new MaximumSumSubarray();
    }

//    Input: arr = [2, 1, 5, 1, 3, 2], k=3
//    Output: 9
//    Explanation: Subarray with maximum sum is [5, 1, 3].

    @Test
    @DisplayName("givenArray_whenPositive_shouldReturnMaxSumOfContinuousKSubArray")
    void givenArray_whenPositive_shouldReturnMaxSumOfContinuousKSubArray() {

        int[] input = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int expectedMaxSum = 9;

        int maxSum = ms.findMaxSumSubArray(k, input);

        assertEquals(expectedMaxSum, maxSum);

    }
}