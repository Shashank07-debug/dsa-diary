package com.arrayProblems;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithSum0 {

    //Optimal Approach TC - > O(N) and SC -> O(N)
    public int maxLen(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSum == 0) {
                maxLen = i + 1;
            }

            if (map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LargestSubArrayWithSum0 solution = new LargestSubArrayWithSum0();

        int[] arr1 = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, -1, 3, -3, 4};

        System.out.println("Max Length (arr1): " + solution.maxLen(arr1)); // Expected 5
        System.out.println("Max Length (arr2): " + solution.maxLen(arr2)); // Expected 0
        System.out.println("Max Length (arr3): " + solution.maxLen(arr3)); // Expected 4
    }
}
