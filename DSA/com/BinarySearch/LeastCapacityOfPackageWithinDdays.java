package com.BinarySearch;

import java.util.Arrays;

public class LeastCapacityOfPackageWithinDdays {
    // Binary Search Approach: O(n * log(sum of weights))
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int daysRequired = check(weights, mid);
            if (daysRequired <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Brute Force Approach: O(n * sum of weights)
    public int shipWithinDaysBruteForce(int[] weights, int days) {
        int max = Arrays.stream(weights).max().getAsInt();
        int sum = Arrays.stream(weights).sum();

        for (int cap = max; cap <= sum; cap++) {
            int daysRequired = check(weights, cap);
            if (daysRequired <= days) return cap; // return capacity
        }

        return -1;
    }

    // Helper method to calculate days required for a given capacity
    private static int check(int[] arr, int cap) {
        int days = 1;
        int load = 0;
        for (int weight : arr) {
            if (load + weight > cap) {
                days++;
                load = weight;
            } else {
                load += weight;
            }
        }
        return days;
    }

    // Main method to test both approaches
    public static void main(String[] args) {
        LeastCapacityOfPackageWithinDdays solution = new LeastCapacityOfPackageWithinDdays();

        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        int resultBinary = solution.shipWithinDays(weights, days);
        System.out.println("Minimum capacity (Binary Search): " + resultBinary);

        int resultBrute = solution.shipWithinDaysBruteForce(weights, days);
        System.out.println("Minimum capacity (Brute Force): " + resultBrute);
    }
}
