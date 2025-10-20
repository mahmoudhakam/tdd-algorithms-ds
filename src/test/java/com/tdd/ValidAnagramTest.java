package com.tdd;

import com.tdd.blind75.ValidAnagram;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {

    ValidAnagram validAnagram;

    @BeforeEach
    void setUp() {
        validAnagram = new ValidAnagram();
    }

    @Test
    @DisplayName("givenTwoStrings_whenStringsAreValid_thenShouldReturnValid")
    void givenTwoStrings_whenStringsAreValid_thenShouldReturnValid() {

        String first = "listen";
        String second = "silent";

        boolean isAnagram = validAnagram.isAnagram(first, second);

        assertTrue(isAnagram);
    }

    @Test
    @DisplayName("giveTwoStrings_whenHaveDifferentLetters_shouldReturnFalse")
    void giveTwoStrings_whenHaveDifferentLetters_shouldReturnFalse() {
        String first = "rat";
        String second = "car";

        boolean isAnagram = validAnagram.isAnagram(first, second);

        assertFalse(isAnagram);
    }

}