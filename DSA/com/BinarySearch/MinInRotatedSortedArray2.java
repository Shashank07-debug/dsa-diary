package com.BinarySearch;

public class MinInRotatedSortedArray2 {
    public int findMin(int[] nums) {
        //TC -> O(LogN) SC - > O(1)
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            // ✅ Handle duplicates
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                ans = Math.min(ans, nums[low]);
                low++;
                high--;
                continue;
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
        MinInRotatedSortedArray2 obj = new MinInRotatedSortedArray2();

        int[] nums1 = {2, 2, 2, 0, 1};
        System.out.println("Min in nums1: " + obj.findMin(nums1)); // 0

        int[] nums2 = {10, 1, 10, 10, 10};
        System.out.println("Min in nums2: " + obj.findMin(nums2)); // 1

        int[] nums3 = {1, 3, 5};
        System.out.println("Min in nums3: " + obj.findMin(nums3)); // 1
    }
}
