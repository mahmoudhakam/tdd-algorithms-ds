package com.tdd.easy.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveZerosTest {

    MoveZeros moveZeros;

    @BeforeEach
    void setUp() {
        moveZeros = new MoveZeros();
    }

    @Test
    @DisplayName("giveArray_whenContainZeros_shouldMoveZerosToEnd")
    void giveArray_whenContainZeros_shouldMoveZerosToEnd() {

        int[] arr = {0, 1, 0, 3, 12};

        int[] expected = {1, 3, 12, 0, 0};

        moveZeros.moveZeroes(arr);

        assertArrayEquals(expected, arr);

    }
}