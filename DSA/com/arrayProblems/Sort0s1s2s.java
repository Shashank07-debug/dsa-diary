package com.arrayProblems;

public class Sort0s1s2s {
    //Quick Sort Brute Force TC - > O(NlogN) SC -> O(N)
    public static void qs(int[] nums, int low, int high) {
        if (low < high) {
            int partition = sort(nums, low, high);
            qs(nums, low, partition - 1);
            qs(nums, partition + 1, high);
        }
    }

    public static int sort(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (nums[i] <= pivot && i <= high - 1) i++;
            while (nums[j] > pivot && j >= low + 1) j--;
            if (i < j) swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //Better Approach TC - > O(2N) SC - > O(1)
    public void sortZeroOneTwo(int[] nums) {
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) cnt0++;
            else if (nums[i] == 1) cnt1++;
            else cnt2++;
        }
        for (int i = 0; i < cnt0; i++) {
            nums[i] = 0;
        }
        for (int i = cnt0; i < cnt0 + cnt1; i++) {
            nums[i] = 1;
        }
        for (int i = cnt0 + cnt1; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    //Optimal Approach (Dutch National Flag Algorithm) TC -> O(N)  SC -> O(1)
    public void sortColors(int[] nums) {
        int low = 0, mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        Sort0s1s2s sorter = new Sort0s1s2s();

        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.println("Before sorting:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

//        sorter.sortZeroOneTwo(nums);
//        qs(nums, 0, nums.length - 1);
        sorter.sortColors(nums);

        System.out.println("\nAfter sorting:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
