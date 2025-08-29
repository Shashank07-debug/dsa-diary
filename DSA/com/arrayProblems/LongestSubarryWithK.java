package com.arrayProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarryWithK {
    // Brute Force Approach TC - > O(N ^ 3)  SC -> O(1)
    public int longestSubarray(int[] nums, int k) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int s = i; s <= j; s++) {
                    sum += nums[s];
                }
                if (sum == k) {
                    len = Math.max(len, (j - i + 1));
                }
            }
        }
        return len;
    }

    //Better Approach TC - > O(N ^ 2)  SC -> O(1)
    public int longestSubarray1(int[] nums, int k) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }

    //Better Approach for array only containing Positive onces but its optimal Approach for array containing the both positive and negative onces TC - > O(N)  SC -> O(N)
    public int longestSubarray2(int[] nums, int k){
        Map<Long, Integer >map = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum == k){
                maxLen = Math.max(maxLen, i+1);
            }
            long rem = sum - k;
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxLen = Math.max(len, maxLen);
            }
            map.putIfAbsent(sum, i);

        }

        return maxLen;
    }

    //Optimal Solution for array Containing only Positive elements TC -> O(N) SC -> O(1)
    public int longestSubarray3(int[] nums, int k){
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLen = 0;
        while(right < n){
            sum += nums[right];
            while(left <= right && sum > k){
                sum -= nums[left];
                left++;
            }
            if(sum == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 0, 3};
        int k = 3;

        LongestSubarryWithK sol = new LongestSubarryWithK();
        int result = sol.longestSubarray2(nums, k);

        System.out.println("Longest subarray length with sum " + k + " = " + result);
    }
}
