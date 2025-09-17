package com.BinarySearch;

import java.util.Arrays;

public class KokoEatingBanana {
    //TC -> O(Max(array) * N) (TLE) SC -> O(1)
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        for(int i = 1; i <= max; i++){
            long requiredTime = func(piles, i);
            if(requiredTime <= (long)h){
                return i;
            }
        }
        return -1;
    }

    private long func(int[] arr, int speed){
        long totalHours = 0;
        for(int bananas : arr){
            totalHours += (bananas + (long)speed - 1) / speed;
        }
        return totalHours;
    }

    //TC -> O(log(Max(Array)) * N) SC -> O(1)
    public int minEatingSpeed1(int[] piles, int h) {
        int high = Arrays.stream(piles).max().getAsInt();
        int low = 1;
        int ans = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            long totalHours = func(piles, mid);
            if(totalHours <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        KokoEatingBanana solver = new KokoEatingBanana();

        // Example 1
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println("Min Eating Speed = " + solver.minEatingSpeed(piles1, h1));
        // Expected: 4

        // Example 2 (from LeetCode hard test)
        int[] piles2 = {332484035,524908576,855865114,632922376,222257295,
                690155293,112677673,679580077,337406589,290818316,
                877337160,901728858,679284947,688210097,692137887,
                718203285,629455728,941802184};
        int h2 = 823855818;
        System.out.println("Min Eating Speed = " + solver.minEatingSpeed1(piles2, h2));
        // Expected: 14
    }
}
