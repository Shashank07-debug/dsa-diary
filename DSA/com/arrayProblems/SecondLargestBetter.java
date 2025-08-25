package com.arrayProblems;
// TC - > O(N + N) = O(2N) SC - > O(1)
public class SecondLargestBetter {
    static int findSecondLargest(int[] nums) {
        int n = nums.length;
        int largest = nums[0];
        int slargest = -1;

        // find largest
        for (int i = 1; i < n; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }

        // find second largest
        for (int i = 0; i < n; i++) {
            if (nums[i] > slargest && nums[i] < largest) {
                slargest = nums[i];
            }
        }
        return slargest;
    }

    public int secondLargestElement(int[] nums) {
        int res = findSecondLargest(nums);
        return res;
    }

    public static void main(String[] args) {
        SecondLargestBetter sol = new SecondLargestBetter();

        int[] arr1 = {3, 1, 5, 2, 4};
        int[] arr2 = {10, 10, 9, 8};
        int[] arr3 = {7, 7, 7};

        System.out.println("Second largest in arr1: " + sol.secondLargestElement(arr1)); // 4
        System.out.println("Second largest in arr2: " + sol.secondLargestElement(arr2)); // 9
        System.out.println("Second largest in arr3: " + sol.secondLargestElement(arr3)); // -1
    }
}


