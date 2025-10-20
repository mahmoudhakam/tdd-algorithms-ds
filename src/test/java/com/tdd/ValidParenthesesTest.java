package com.tdd;

import com.tdd.blind75.ValidParentheses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    ValidParentheses validParentheses;

    @BeforeEach
    void setUp() {
        validParentheses = new ValidParentheses();
    }

    @Test
    @DisplayName("givenString_whenOpenAndClosedBracketsAreNotCorrect_thenReturnFalse")
    void isValid() {
        String input = "[}";

        boolean isvalid = validParentheses.isValid(input);

        assertFalse(isvalid);
    }

    @Test
    @DisplayName("givenString_whenOpenAndClosedBracketsCorrect_thenReturnTrue")
    void givenString_whenOpenAndClosedBracketsCorrect_thenReturnTrue() {
        String input = "[([{}])]";

        boolean isvalid = validParentheses.isValid(input);

        assertTrue(isvalid);
    }
}