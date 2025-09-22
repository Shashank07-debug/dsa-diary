package com.BinarySearch;

import java.util.Arrays;

public class FindMinimumDivisor {
    //Optimal Approach Tc -> O(Log(Max) * N) SC -> O(1)
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(nums, mid, threshold)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Brute-force approach Tc -> O(MAX * N) SC -> O(1)
    public int smallestDivisorBruteForce(int[] nums, int threshold) {
        int max = Arrays.stream(nums).max().getAsInt();
        for (int d = 1; d <= max; d++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num + d - 1) / d; // ceiling division
            }
            if (sum <= threshold) {
                return d;
            }
        }
        return -1;
    }

    private static boolean check(int[] arr, int d, int threshold) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (arr[i] + d - 1) / d;
        }
        return (sum <= threshold);
    }
    public static void main(String[] args) {
        FindMinimumDivisor solver = new FindMinimumDivisor();
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        int resultBinary = solver.smallestDivisor(nums, threshold);
        System.out.println("Smallest Divisor (Binary Search): " + resultBinary);

        int resultBruteForce = solver.smallestDivisorBruteForce(nums, threshold);
        System.out.println("Smallest Divisor (Brute Force): " + resultBruteForce);
    }
}
