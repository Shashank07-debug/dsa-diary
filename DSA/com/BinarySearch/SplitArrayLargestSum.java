package com.BinarySearch;

import java.util.Arrays;

public class SplitArrayLargestSum {
    // TC -> O(Log(sum - max) + 1) * O(n) SC -> O(1)
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        int result = -1;

        while(low <= high){
            int mid = (low + high) / 2;
            int maxArray = fun(nums, mid);
            if(maxArray <= k){
                result = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }

    private static int fun(int[] nums, int k){
        int split = 1;
        int noOfSplit = 0;
        for(int i = 0; i < nums.length; i++){
            if(noOfSplit + nums[i] <= k){
                noOfSplit += nums[i];
            }else{
                split++;
                noOfSplit = nums[i];
            }
        }
        return split;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum solver = new SplitArrayLargestSum();
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        int result = solver.splitArray(nums, k);
        System.out.println("The minimum largest sum for " + k + " subarrays is: " + result);
    }
}
