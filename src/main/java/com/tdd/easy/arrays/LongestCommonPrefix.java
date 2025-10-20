package com.tdd.easy.arrays;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String prefix = "";
        for (int i = 0; i < strs.length; i++) {
            char c = strs[i].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[i].startsWith(prefix)) {
                    prefix += c;
                }
            }
        }
        return prefix;
    }
}
