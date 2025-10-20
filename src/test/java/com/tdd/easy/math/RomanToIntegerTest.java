package com.tdd.easy.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {

    RomanToInteger romanToInteger;

    @BeforeEach
    void setUp() {
        romanToInteger = new RomanToInteger();
    }

    @Test
    @DisplayName("givenNumber_whenRomanFormat_returnIntegerValue")
    void romanToInt() {
        String input = "";
        int expected = 1;

        int result = romanToInteger.romanToInt(input);

        assertEquals(expected, result);
    }
}