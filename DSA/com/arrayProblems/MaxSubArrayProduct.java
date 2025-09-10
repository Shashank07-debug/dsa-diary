package com.arrayProblems;

public class MaxSubArrayProduct {
    //Navie Brute Force Approach TC -> O(N ^ 3) SC -> O(1)
    public int maxProduct(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int product = 1;
                for (int k = i; k <= j; k++) {
                    product *= nums[k];
                }
                maxi = Math.max(maxi, product);
            }
        }
        return maxi;
    }

    //Better Approach TC -> O(N ^ 2) SC -> O(N)
    public int maxProduct1(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                maxi = Math.max(maxi, product);
            }
        }
        return maxi;
    }

    // Optimal Prefix-Suffix Approach TC -> O(N) SC -> O(1)
    public int maxProduct2(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - i - 1];
            maxi = Math.max(maxi, Math.max(prefix, suffix));
        }
        return maxi;
    }

    public static void main(String[] args) {
        MaxSubArrayProduct solver = new MaxSubArrayProduct();

        int[] nums = {2, 3, -2, 4};

        System.out.println("Naive O(N^3) Result: " + solver.maxProduct(nums));
        System.out.println("Better O(N^2) Result: " + solver.maxProduct1(nums));
        System.out.println("Optimal O(N) Result: " + solver.maxProduct2(nums));
    }
}
