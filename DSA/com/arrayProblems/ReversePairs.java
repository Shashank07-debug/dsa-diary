package com.arrayProblems;

import java.util.Arrays;
import java.util.Scanner;

public class ReversePairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of array Elements : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i =0 ; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int countPairs = ms(nums, 0, nums.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(nums));
        System.out.println("Number of Inversions: " + countPairs);
    }

    //Optimal Solution TC -> O(NLogN) SC -> O(N)
    public static int ms(int[]nums, int low, int high){
        int cnt = 0;
        if(low >= high) return cnt;
        int mid = (low + high)/ 2;
        cnt += ms(nums, low, mid);
        cnt += ms(nums, mid + 1, high);
        cnt += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return cnt;
    }

    public static int countPairs(int[] nums, int low, int mid, int high){
        int cnt = 0;
        int right = mid + 1;
        for(int i = low; i <= mid; i++){
            while(right <= high && (long)nums[i] > 2L * nums[right]){
                right++;
            }
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public static void merge(int[] nums, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int right = mid + 1;
        int i = 0;
        int left = low;
        while(left <= mid && right <= high){
            if(nums[left] < nums[right]){
                temp[i++] = nums[left++];
            }else{
                temp[i++] = nums[right++];
            }
        }
        while(left <= mid){
            temp[i++] = nums[left++];
        }
        while(right <= high){
            temp[i++] = nums[right++];
        }
        for(int j = low; j <= high; j++){
            nums[j] = temp[j - low];
        }
    }
}
