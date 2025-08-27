package com.arrayProblems;

public class RotateArrayByDPlaces {
    //Brute Force Approach
    public void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] temp = new int[k];
        for(int i = 0; i < k; i++){
            temp[i] = nums[i];
        }
        for(int i = k; i < n; i++){
            nums[i - k] = nums[i];
        }
        for(int i = n - k; i < n; i++){
            nums[i] = temp[i - (n - k)];
        }
    }
    //Optimal Approach
    public void rotateArrayOptimal(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, k - 1);
        reverse(nums, k , n - 1);
        reverse(nums, 0, n - 1);
    }
    static void reverse(int[]nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        RotateArrayByDPlaces obj = new RotateArrayByDPlaces();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        System.out.println("Original Array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        obj.rotateArrayOptimal(nums, k);

        System.out.println("\nArray after left rotation by " + k + " places:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
