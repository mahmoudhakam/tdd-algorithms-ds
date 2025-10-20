package com.microservices.test.blind75;

// https://www.designgurus.io/viewer/document/grokking-the-coding-interview/63d906094c5ef6536969a376

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate {

    /**
     * Sorted solution:
     *  sort Array
     *  compare current == next element
     *
     *
     *  HashSet solution
     *      hashset contain element, return
     *      else put element in hashset
     * */

    public boolean containsDuplicateSortedArray(int[] nums) {

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    public boolean containsDuplicateHashSet(int[] nums) {

        Set<Integer> noDuplicate = new HashSet<>();

        for (int num : nums) {
            if (noDuplicate.contains(num)) {

                return true;
            }
            noDuplicate.add(num);
        }

        return false;
    }

    static void main(String[] args) {
        ContainDuplicate dc = new ContainDuplicate();
        boolean result = dc.containsDuplicateSortedArray(new int[]{1, 2, 3, 4});
    }
}
