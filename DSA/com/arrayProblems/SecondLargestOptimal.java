package com.arrayProblems;
//TC - > O(N) SC -> O(1)
public class SecondLargestOptimal {

    static int findSecondLargest(int[] nums) {
        int n = nums.length;
        if (n < 2) return -1;
        int largest = nums[0];
        int slargest = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (nums[i] > largest) {
                slargest = largest;
                largest = nums[i];
            } else if (nums[i] < largest && nums[i] > slargest) {
                slargest = nums[i];
            }
        }
        return (slargest == Integer.MIN_VALUE) ? -1 : slargest;
    }

    public int secondLargestElement(int[] nums) {
        int res = findSecondLargest(nums);
        return res;
    }

    public static void main(String[] args) {
        SecondLargestOptimal sol = new SecondLargestOptimal();

        int[] arr1 = {3, 1, 5, 2, 4};
        int[] arr2 = {10, 10, 9, 8};
        int[] arr3 = {7, 7, 7};
        int[] arr4 = {-5, -2, -8, -1};

        System.out.println("Second largest in arr1: " + sol.secondLargestElement(arr1)); // 4
        System.out.println("Second largest in arr2: " + sol.secondLargestElement(arr2)); // 9
        System.out.println("Second largest in arr3: " + sol.secondLargestElement(arr3)); // -1
        System.out.println("Second largest in arr4: " + sol.secondLargestElement(arr4)); // -2
    }
}

