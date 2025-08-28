package com.arrayProblems;

public class LargestConsecutiveOnes {
    //Optimal Solution Time Complexity: O(n), Space Complexity: O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
                max = Math.max(max, cnt);
            } else {
                cnt = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestConsecutiveOnes obj = new LargestConsecutiveOnes();
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(obj.findMaxConsecutiveOnes(nums));
    }
}
