package com.arrayProblems;

import java.util.Arrays;

public class NextPermutation {
    //Optimal Solution TC -> O(3N)  SC -> O(1) we are modifying the array so in that case O(N)
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        // Step 1: Find The longest matching prefix
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // Step 2: If no such index found, reverse whole array
        if (idx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find next greater element on right side and swap
        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        // Step 4: Reverse the suffix
        reverse(nums, idx + 1, n - 1);
    }

    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        NextPermutation solver = new NextPermutation();

        int[] nums1 = {1, 2, 3};
        solver.nextPermutation(nums1);
        System.out.println("Next permutation of [1,2,3]: " + Arrays.toString(nums1));

        int[] nums2 = {3, 2, 1};
        solver.nextPermutation(nums2);
        System.out.println("Next permutation of [3,2,1]: " + Arrays.toString(nums2));

        int[] nums3 = {1, 1, 5};
        solver.nextPermutation(nums3);
        System.out.println("Next permutation of [1,1,5]: " + Arrays.toString(nums3));

        int[] nums4 = {1, 3, 2};
        solver.nextPermutation(nums4);
        System.out.println("Next permutation of [1,3,2]: " + Arrays.toString(nums4));
    }
}
