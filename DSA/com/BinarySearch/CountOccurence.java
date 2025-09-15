package com.BinarySearch;

import java.util.Arrays;

public class CountOccurence {
    //TC -> O(N) SC -> O(1)
    public int searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = -1;
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                if (first == -1) first = i;
                last = i;
            }
        }
        return (last - first) + 1;
    }

    //TC -> O(LogN) SC -< O(1)
    public int searchRange1(int[] nums, int target) {
        int n = nums.length;
        int first = firstOccurence1(nums, target, n);
        int last = lastOccurence1(nums, target, n);
        return (last - first) + 1;
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

    //Pure Binary Search implementation TC -> O(LogN) SC -< O(1)
    private int firstOccurence1(int[] nums, int target, int n){
        int low = 0;
        int high = n - 1;
        int first = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                first = mid;
                high = mid - 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return first;
    }

    private int lastOccurence1(int[] nums, int target, int n){
        int low = 0;
        int high = n - 1;
        int first = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                first = mid;
                low = mid + 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return first;
    }


    public static void main(String[] args) {
        CountOccurence obj = new CountOccurence();

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int result = obj.searchRange1(nums, target);
        System.out.println("Number of Occurences : " + result);
    }
}
