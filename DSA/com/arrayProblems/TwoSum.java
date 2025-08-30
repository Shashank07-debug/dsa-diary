package com.arrayProblems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //Brute Force Approach TC - > O(n ^ 2)  SC - > O(1)
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    //Optimal Approach using Hash Map TC - > O(n) SC - > O(n)
    public int[] twoSum1(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int num = nums[i];
            int moreNeeded = target - num;
            if(map.containsKey(moreNeeded)){
                return new int[]{map.get(moreNeeded), i};
            }
            map.put(num, i);
        }
        return new int[0];
    }

    //Optimal Approach without using HashMap
    public static int[] twoSum2(int[] nums, int target){
        for(int i = 1; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(nums[j] + nums[j - i] == target){
                    return new int[]{j - i, j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum2(nums, target);

        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found");
        }
    }
}
