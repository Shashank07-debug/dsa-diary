package com.arrayProblems;

public class RotateArrayByOne {
    public void rotateArrayByOne(int[] nums) {
        int temp = nums[0];
        for(int i = 1; i < nums.length; i++){
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = temp;
    }
    public static void main(String[] args) {
        RotateArrayByOne sol = new RotateArrayByOne();
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println("Original Array:");
        for (int n : nums) {
            System.out.print(n + " ");
        }

        sol.rotateArrayByOne(nums);

        System.out.println("\nArray after rotation by one:");
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

}
