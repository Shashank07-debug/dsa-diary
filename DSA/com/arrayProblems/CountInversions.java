package com.arrayProblems;

import java.util.Arrays;
import java.util.Scanner;

public class CountInversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of array Elements : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i =0 ; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int inversions = ms(nums, 0, nums.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(nums));
        System.out.println("Number of Inversions: " + inversions);
    }
    //Optimal Solution TC -> O(NLogN) SC -> O(N)
    public static int ms(int[]nums, int low, int high){
        int cnt = 0;
        if(low >= high) return cnt;
        int mid = (low + high)/ 2;
        cnt += ms(nums, low, mid);
        cnt += ms(nums, mid + 1, high);
        cnt += merge(nums, low, mid, high);
        return cnt;
    }

    public static int merge(int[] nums, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int right = mid + 1;
        int i = 0;
        int left = low;
        int cnt = 0;
        while(left <= mid && right <= high){
            if(nums[left] < nums[right]){
                temp[i++] = nums[left++];
            }else{
                cnt += (mid - left + 1);
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
        return cnt;
    }
}
