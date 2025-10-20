package com.tdd.blind75;

import java.util.HashMap;
import java.util.Map;

// https://www.designgurus.io/viewer/document/grokking-the-coding-interview/65165366d223ca367e8f855e

public class TwoSum {

    /**
     *
     * complement = target - currentElement
     * HashMap (currentElement, index)
     * check complement as a Hashmap key
     */

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> complementMap = new HashMap<>();
        //3, 2, 4
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // 3, 4, 2
            System.out.println("index: " + i + "  element: " + nums[i] + "  complement: " + complement);
            System.out.println("complementMap: " + complementMap);
            if (complementMap.containsKey(complement)) { //false, false
                System.out.println("result: " + complementMap.get(complement) + " " + i);
                return new int[]{complementMap.get(complement), i};
            }
            complementMap.put(nums[i], i); //{3,0} , {2,1} , {,}
        }


        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        // Test the algorithm with example inputs
        int[] result1 = solution.twoSum(new int[]{3, 2, 4}, 6);
        // Output the results
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]");

//        int[] result2 = solution.twoSum(new int[]{-1, -2, -3, -4, -5}, -8);
//        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]");
//
//        int[] result3 = solution.twoSum(new int[]{10, 15, 21, 25, 30}, 45);
//        System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]");
    }
}
