package com.arrayProblems;

import java.util.HashMap;
import java.util.Map;

public class SingleElement {
    // Brute Force Approach Time Complexity: O(n^2), Space Complexity: O(1)
    public int singleNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == num) {
                    count++;
                }
            }
            if (count == 1) return num;
        }
        return -1;
    }
    //Better Approach Time Complexity: O(n), Space Complexity: O(max(nums))
    public int singleNumber1(int[] nums) {
        int n = nums.length;
        int maxi = nums[0];

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        int[] hash = new int[maxi + 1];
        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }

        for (int i = 0; i < n; i++) {
            if (hash[nums[i]] == 1) return nums[i];
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        //Better Approach 2 Using a HashMap to count frequencies: Time Complexity O(n), Space Complexity O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }

        return -1;
    }
    //Optimal Solution TC -> O(n) SC - > O(1)
    public int singleNumber3(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++){
            xor = xor ^ nums[i];
        }
        return xor;
    }
    public static void main(String[] args) {
        SingleElement solution = new SingleElement();
        int[] nums = {4, 1, 2, 1, 2};
        int result = solution.singleNumber(nums);
        System.out.println("The single number is: " + result);
    }
}
