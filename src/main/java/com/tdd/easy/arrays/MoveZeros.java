package com.tdd.easy.arrays;

public class MoveZeros {

    /**
     * Tags: Easy - Array - Two pointers
     * <p>
     * <p>
     * Solution:
     * two pointers (one keep last zero index, and other used to switch
     * check element not equal zero
     * check two pointers not equal
     * switch current to temp
     * swtich current = element[zeroindex]
     * switch element[zeroindex]= temp
     * <p>
     * increment zero index
     *
     *
     */

    //For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
    public void moveZeroes(int[] nums) {

        int lastIndexZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {

                if (lastIndexZero != i) {
                    // temp = current
                    int temp = nums[i];
                    // switch current with zero-index element
                    nums[i] = nums[lastIndexZero];
                    //switch zero-index element with temp
                    nums[lastIndexZero] = temp;
                }

                lastIndexZero++;
            }
        }
    }
}
