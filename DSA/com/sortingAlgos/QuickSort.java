package com.sortingAlgos;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of array Elements : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i =0 ; i < n; i++){
            nums[i] = sc.nextInt();
        }
        qs(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    static void qs(int[] nums, int low, int high){
        if(low < high){
            int partition = sort(nums, low, high);
            qs(nums, low, partition - 1);
            qs(nums, partition+ 1, high);
        }
    }

    static int sort(int[] nums, int low, int high){
        int pivot = nums[low];
        int i = low;
        int j = high;
        while(i < j){
            while(nums[i] <= pivot && i <= high - 1) i++;
            while(nums[j] > pivot && j >= low + 1) j--;
            if(i  < j) swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }
    static void swap(int[]nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
