package com.BinarySearch;

public class SearchInRotatedSortedArray1 {
    //TC -> O(logN) Sc -> O(1)
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) return mid;

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray1 obj = new SearchInRotatedSortedArray1();

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        int result = obj.search(nums, target);
        System.out.println("Index of " + target + ": " + result);
    }
}
