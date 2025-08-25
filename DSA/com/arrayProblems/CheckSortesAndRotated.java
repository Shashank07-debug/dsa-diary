package com.arrayProblems;

public class CheckSortesAndRotated {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckSortesAndRotated sol = new CheckSortesAndRotated();
        int[] arr1 = {3, 4, 5, 1, 2};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {2, 1, 3, 4, 5};
        int[] arr4 = {5, 1, 2, 3, 4};
        int[] arr5 = {1, 3, 2, 4, 5};

        System.out.println("Test case 1: " + sol.check(arr1));
        System.out.println("Test case 2: " + sol.check(arr2));
        System.out.println("Test case 3: " + sol.check(arr3));
        System.out.println("Test case 4: " + sol.check(arr4));
        System.out.println("Test case 5: " + sol.check(arr5));
    }
}

