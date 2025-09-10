package com.BinarySearch;

public class BinarySearch {
    //TC -> O(LogN) SC -> O(1)

    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) return -1;

        int mid = (low + high) / 2;

        if (nums[mid] == target) return mid;
        else if (target > nums[mid]) {
            return binarySearch(nums, mid + 1, high, target);
        } else {
            return binarySearch(nums, low, mid - 1, target);
        }
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        return binarySearch(nums, 0, n - 1, target);
    }

    public static void main(String[] args) {
        BinarySearch solver = new BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};

        // Test cases
        System.out.println(solver.search(nums, 9));  // Output: 4
        System.out.println(solver.search(nums, 2));  // Output: -1
        System.out.println(solver.search(nums, -1)); // Output: 0
        System.out.println(solver.search(nums, 12)); // Output: 5
    }
}

