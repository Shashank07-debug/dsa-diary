package com.BinarySearch;

import java.util.Arrays;

public class FirstAndLastOccurence {
    //TC -> O(N) SC -> O(1)
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = -1;
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                if (first == -1) first = i;
                last = i;
            }
        }
        return new int[]{first, last};
    }

    //TC -> O(LogN) SC -< O(1)
    public int[] searchRange1(int[] nums, int target) {
        int n = nums.length;
        int first = firstOccurence(nums, target, n);
        int last = lastOccurence(nums, target, n);
        return new int[]{first, last};
    }

    private static int firstOccurence(int[] nums, int target, int n) {
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) ans = mid;
                high = mid - 1; // go left
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int lastOccurence(int[] nums, int target, int n) {
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) ans = mid;
                low = mid + 1; // go right
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        FirstAndLastOccurence obj = new FirstAndLastOccurence();

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = obj.searchRange(nums, target);
        System.out.println("First and Last Position: " + Arrays.toString(result));
    }
}
