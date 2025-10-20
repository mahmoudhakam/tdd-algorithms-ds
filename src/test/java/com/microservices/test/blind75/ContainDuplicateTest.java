package com.microservices.test.blind75;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainDuplicateTest {

    ContainDuplicate containDuplicate;

    @BeforeEach
    void setUp() {
        containDuplicate = new ContainDuplicate();
    }

    @Test
    @DisplayName("Given there are no duplicates in the array, when input [1, 2, 3, 4] then return False")
    void givenNoDuplicate_whenUniqueArray_thenFalse() {
        int[] arr = {1, 2, 3, 4};
        boolean result = containDuplicate.containsDuplicateHashSet(arr);
        assertFalse(result);
    }

    @Test
    @DisplayName("Given array with duplicate, when array=[3, 2, 6, -1, 2, 1], then return true")
    void givenArrayWithDuplicate_whenUniqueArray_thenTrue() {
        int[] arr = {3, 2, 6, -1, 2, 1};
        boolean result = containDuplicate.containsDuplicateHashSet(arr);
        assertTrue(result);
    }

    @Test
    @DisplayName("Given array containing minus numbers with no duplicate, when array=[3, 2, 6, -1, 2, 1], then return true")
    void givenArrayContainingMinusNumbers_whenUniqueArray_thenTrue() {
        int[] arr = {3, 2, 6, -1, 2, 1};
        boolean result = containDuplicate.containsDuplicateSortedArray(arr);
        assertTrue(result);
    }


}