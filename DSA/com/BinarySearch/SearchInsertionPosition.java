package com.BinarySearch;

public class SearchInsertionPosition {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int ans = n;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SearchInsertionPosition obj = new SearchInsertionPosition();
        int[] nums = {1, 3, 5, 6};
        int target1 = 5;
        int target2 = 2;
        int target3 = 7;

        System.out.println("Insert position of " + target1 + " is: " + obj.searchInsert(nums, target1));
        System.out.println("Insert position of " + target2 + " is: " + obj.searchInsert(nums, target2));
        System.out.println("Insert position of " + target3 + " is: " + obj.searchInsert(nums, target3));
    }
}
