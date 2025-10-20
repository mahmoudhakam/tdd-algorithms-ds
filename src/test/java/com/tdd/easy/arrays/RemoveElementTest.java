package com.tdd.easy.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {

    RemoveElement obj;

    @BeforeEach
    void setUp() {
        obj = new RemoveElement();
    }

    @Test
    @DisplayName("givenArray_whenContainTheDesiredVal_thenReturnLength")
    void removeElement() {

        int[] input = {0,1,2,2,3,0,4,2};
        int val = 2;
        int expectedLength = 5;

        int length = obj.removeElement(input, val);

        assertEquals(expectedLength, length);

    }
}