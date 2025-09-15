package com.BinarySearch;

public class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        //TC -> O(LogN) SC -> O(1)
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If the entire subarray is already sorted
            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            }
            // Right half is sorted
            else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }

    // ✅ Main for testing
    public static void main(String[] args) {
        MinInRotatedSortedArray obj = new MinInRotatedSortedArray();

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Min in nums1: " + obj.findMin(nums1)); // 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Min in nums2: " + obj.findMin(nums2)); // 0

        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Min in nums3: " + obj.findMin(nums3)); // 11
    }
}
