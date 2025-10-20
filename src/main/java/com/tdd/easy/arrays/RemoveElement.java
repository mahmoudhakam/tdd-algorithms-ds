package com.tdd.easy.arrays;

public class RemoveElement {

    /**
     * Tags: Easy - Array - Two pointers
     * <p>
     *
     * Solution:
     * compare the current element with val, if not, increment length
     *
     */

    public int removeElement(int[] nums, int val) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                length++;
            }
        }
        return length;
    }
}
