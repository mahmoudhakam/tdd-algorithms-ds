package com.tdd.easy.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    LongestCommonPrefix lcp;

    @BeforeEach
    void setUp() {
        lcp = new LongestCommonPrefix();
    }

    @Test
    void longestCommonPrefix() {
        String result = lcp.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        assertEquals("fl", result);
    }
}