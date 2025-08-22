package com.sortingAlgos;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of array Elements : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i =0 ; i < n; i++){
            nums[i] = sc.nextInt();
        }
        ms(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void ms(int[]nums, int low, int high){
        if(low >= high) return;
        int mid = (low + high)/ 2;
        ms(nums, low, mid);
        ms(nums, mid + 1, high);
        merge(nums, low, mid, high);
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
