package com.BinarySearch;

public class UpperBound {
    public int upperBound(int[] nums, int x) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        UpperBound obj = new UpperBound();
        int[] nums = {1, 2, 4, 6, 8, 10};
        int x = 6;
        int index = obj.upperBound(nums, x);
        System.out.println("Upper bound index of " + x + " is: " + index);
    }
}
