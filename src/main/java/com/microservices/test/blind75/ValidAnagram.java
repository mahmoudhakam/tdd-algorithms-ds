package com.microservices.test.blind75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ValidAnagram {

    /**
     * Solution: keep track of no of occurence of letters is hashset for both
     * At the end hashset should be empty
     *
     */
    public boolean isAnagram(String first, String second) {

        if (first.length() != second.length()) {
            return false;
        }

        HashSet<Character> occurence = new HashSet<>();

        for (int i = 0; i < first.length(); i++) {
            occurence.add(first.charAt(i));
//            System.out.println("Occurence: " + occurence);
        }

        for (int i = 0; i < second.length(); i++) {
            occurence.remove(second.charAt(i));
        }

        return occurence.isEmpty();
    }
}
