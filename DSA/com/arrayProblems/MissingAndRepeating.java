package com.arrayProblems;

public class MissingAndRepeating {
    //Better Approach TC - > O(2N) SC -> O(N)
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n + 1];
        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }
        int missing = -1;
        int repeating = -1;
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) repeating = i;
            else if (hash[i] == 0) missing = i;
            if (missing != -1 && repeating != -1) break;
        }
        return new int[]{repeating, missing};
    }

    //Optimal Approach 1 TC -> O(N) SC -> O(1)
    public int[] findMissingRepeatingNumbers1(int[] nums) {
        long n = nums.length;
        long sn = n * (n + 1) / 2;
        long s2n = n * (n + 1) * (2 * n + 1) / 6;
        long s = 0;
        long s2 = 0;
        for (int i = 0; i < n; i++) {
            s += (long) nums[i];
            s2 += (long) nums[i] * (long) nums[i];
        }
        long val1 = s - sn;
        long val2 = s2 - s2n;
        val2 = val2 / val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;
        return new int[]{(int) x, (int) y};
    }

    //Optimal Approach 2 will be added once i learn bit manipulation

    public static void main(String[] args) {
        MissingAndRepeating obj = new MissingAndRepeating();

        int[] nums = {3, 1, 2, 5, 3}; // Example input

        int[] ans1 = obj.findMissingRepeatingNumbers(nums);
        System.out.println("Better Approach -> Repeating: " + ans1[0] + ", Missing: " + ans1[1]);

        int[] ans2 = obj.findMissingRepeatingNumbers1(nums);
        System.out.println("Optimal Approach -> Repeating: " + ans2[0] + ", Missing: " + ans2[1]);
    }
}
