package com.arrayProblems;

import java.util.Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates sol = new RemoveDuplicates();

        int[] arr1 = {1, 1, 2};
        int[] arr2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] arr3 = {1, 2, 3, 4, 5};

        int len1 = sol.removeDuplicates(arr1);
        int len2 = sol.removeDuplicates(arr2);
        int len3 = sol.removeDuplicates(arr3);

        System.out.println("Array 1 after removing duplicates: " + Arrays.toString(Arrays.copyOf(arr1, len1)));
        System.out.println("Array 2 after removing duplicates: " + Arrays.toString(Arrays.copyOf(arr2, len2)));
        System.out.println("Array 3 after removing duplicates: " + Arrays.toString(Arrays.copyOf(arr3, len3)));
    }
}

