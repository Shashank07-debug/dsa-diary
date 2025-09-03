package com.arrayProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestContinuousSequence {
    //Brute Force Approach TC - > O(N ^ 2) SC - > O(1)
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int longest = 1;

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            int x = nums[i] + 1;
            while (linearSearch(nums, n, x)) {
                x += 1;
                cnt += 1;
            }
            longest = Math.max(cnt, longest);
        }

        return longest;
    }

    public static boolean linearSearch(int[] num, int n, int x) {
        for (int i = 0; i < n; i++) {
            if (num[i] == x) {
                return true;
            }
        }
        return false;
    }

    //Better Solution TC -> O(NLogN) + O(N)  SC - > O(1)
    public int longestConsecutive2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        Arrays.sort(nums);
        int largest = 1;
        int lastSmallest = Integer.MIN_VALUE;
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == lastSmallest) {
                cnt++;
                lastSmallest = nums[i];
            } else if (nums[i] != lastSmallest) {
                cnt = 1;
                lastSmallest = nums[i];
            }
            largest = Math.max(cnt, largest);
        }
        return largest;
    }

    //Optimal Solution TC -> O(N) + O(N) = O(2N) SC -> O(N)
    public int longestConsecutive3(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }
        for(int it : set){
            if(!set.contains(it - 1)){
                int cnt = 1;
                int x = it;
                while(set.contains(x + 1)){
                    x = x + 1;
                    cnt++;
                }
                longest = Math.max(cnt, longest);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestContinuousSequence sol = new LongestContinuousSequence();

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Test Case 1: " + sol.longestConsecutive2(nums1)); // Output: 4

        int[] nums2 = {1, 9, 3, 10, 4, 20, 2};
        System.out.println("Test Case 2: " + sol.longestConsecutive3(nums2)); // Output: 4

        int[] nums3 = {8, 7, 6, 5, 4, 3};
        System.out.println("Test Case 3: " + sol.longestConsecutive(nums3)); // Output: 6

        int[] nums4 = {};
        System.out.println("Test Case 4: " + sol.longestConsecutive(nums4)); // Output: 0

        int[] nums5 = {5, 5, 5, 5};
        System.out.println("Test Case 5: " + sol.longestConsecutive(nums5)); // Output: 1
    }
}
