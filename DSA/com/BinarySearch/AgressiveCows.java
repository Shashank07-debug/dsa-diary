package com.BinarySearch;

import java.util.Arrays;

public class AgressiveCows {
    // TC -> O((maxi - mini)) * O(N) SC -> O(1)
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int maxi = Arrays.stream(nums).max().getAsInt();
        int mini = Arrays.stream(nums).min().getAsInt();
        for (int i = 1; i <= maxi - mini; i++) {
            if (cowPlace(nums, i, k) == true) continue;
            else return (i - 1);
        }
        return maxi - mini;
    }
    //TC -> O(Log(maxi - mini)) * O(N) SC - > O(1)
    public int aggressiveCows1(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 1;
        int high = nums[nums.length - 1] - nums[0];
        while(low <= high){
            int mid = (low + high) / 2;
            if(cowPlace(nums, mid, k) == true){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high;
    }
    private static boolean cowPlace(int[] nums, int dist, int cows) {
        int cntCows = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last >= dist) {
                last = nums[i];
                cntCows++;
            }
        }
        if (cntCows >= cows) return true;
        return false;
    }

    public static void main(String[] args) {
        AgressiveCows solver = new AgressiveCows();

        int[] stalls = {1, 2, 8, 4, 9};
        int cows = 3;

        int resultBrute = solver.aggressiveCows(stalls.clone(), cows);
        int resultBinary = solver.aggressiveCows1(stalls.clone(), cows);

        System.out.println("Brute Force Result: " + resultBrute);
        System.out.println("Binary Search Result: " + resultBinary);
    }
}

