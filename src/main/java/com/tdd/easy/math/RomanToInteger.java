package com.tdd.easy.math;

import java.util.HashMap;

public class RomanToInteger {

    /**
     * Tags: Easy- Math- String
     *
     */

    public int romanToInt(String s) {
        HashMap<Character, Integer> romanIntegers = new HashMap<Character, Integer>();
        initHelper(romanIntegers);

        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i);
            //TODO: later on for now
        }


        return 0;
    }


    private void initHelper(HashMap<Character, Integer> helper) {
        helper.put('M', 1000);
        helper.put('D', 500);
        helper.put('C', 100);
        helper.put('L', 50);
        helper.put('X', 10);
        helper.put('V', 5);
        helper.put('I', 1);

    }
}
