package com.BinarySearch;

import java.util.Arrays;

public class minNoOfBouquets {
    //Brute Force TC -> O(max - min + 1 * N) SC -> O(1)
    private static boolean possible(int[] arr, int day, int m, int k){
        int n = arr.length;
        int cnt = 0;
        int noOfBouquets = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] <= day){
                cnt++;
            } else {
                noOfBouquets += (cnt / k);
                cnt = 0;
            }
        }
        noOfBouquets += (cnt / k);
        return (noOfBouquets >= m);
    }

    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long)(m * k);
        if(val > (long)bloomDay.length) return -1;

        int max = Arrays.stream(bloomDay).max().getAsInt();
        int min = Arrays.stream(bloomDay).min().getAsInt();

        for(int i = min; i <= max; i++){
            if(possible(bloomDay, i, m, k)){
                return i;
            }
        }
        return -1;
    }
    //Optimized Solution TC -> O(N * log(max - min)) SC -> O(1)
    public int minDays1(int[] bloomDay, int m, int k) {
        long val = (long)(m * k);
        if(val > (long)bloomDay.length)return -1;
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(possible(bloomDay, mid, m, k) == true){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        minNoOfBouquets solution = new minNoOfBouquets();
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;
        int result = solution.minDays(bloomDay, m, k);
        System.out.println("Minimum days: " + result);
    }
}
