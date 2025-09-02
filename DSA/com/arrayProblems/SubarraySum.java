package com.arrayProblems;

import java.util.Arrays;

public class SubarraySum {
    //Brute Force Solution TC - > O(N ^ 3) SC - > O(1)
    public static int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxi = Math.max(sum, maxi);
            }
        }
        return maxi;
    }

    //Better Approach TC -> O(n ^ 2) SC -> O(1)
    public static int maxSubArray2(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxi = Math.max(sum, maxi);
            }

        }
        return maxi;
    }

    //Optimal Solution TC -> O(N) SC -> O(1) (Kadane's Algorithm)
    public static int maxSubArray3(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = sum > max ? sum : max;
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
    //Optimal Solution which return index of subarray
    public static int[] maxSubArray4(int[] nums) {
        int max = nums[0];
        int sum = 0;
        int start = 0;
        int subStart = 0;
        int subEnd = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum == 0) start = i;
            sum += nums[i];
            if(sum > max){
                max = sum;
                subStart = start;
                subEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return new int[]{subStart, subEnd};
    }




    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum is: " + maxSubArray2(nums));
        int[] res = maxSubArray4(nums);
        System.out.println(Arrays.toString(res));
    }
}
