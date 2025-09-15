package com.BinarySearch;

public class SearchInRotatedSortedArray2 {
    //TC -> O(LogN) SC -> O(1)
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return true;

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            } else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    // ✅ Main method for testing
    public static void main(String[] args) {
        SearchInRotatedSortedArray2 obj = new SearchInRotatedSortedArray2();

        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        int target1 = 0;
        System.out.println("Search 0 in nums1: " + obj.search(nums1, target1)); // true

        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        int target2 = 3;
        System.out.println("Search 3 in nums2: " + obj.search(nums2, target2)); // false

        int[] nums3 = {1, 1, 1, 1, 2, 1, 1};
        int target3 = 2;
        System.out.println("Search 2 in nums3: " + obj.search(nums3, target3)); // true
    }
}
