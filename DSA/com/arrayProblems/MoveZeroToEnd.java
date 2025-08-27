package com.arrayProblems;
import java.util.ArrayList;
import java.util.Arrays;
public class MoveZeroToEnd {

    public void moveZeroes(int[] nums) {
        //Brute Force Approach TC -> O(2N) SC -> O(N) in worst case
        int n = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                temp.add(nums[i]);
            }
        }
        int nz = temp.size();
        for (int i = 0; i < nz; i++) {
            nums[i] = temp.get(i);
        }
        for (int i = nz; i < n; i++) {
            nums[i] = 0;
        }
    }

    // Optimized Two-Pointer Approach -> TC: O(N), SC: O(1)

    public void moveZeroes1(int[] nums) {
        int n = nums.length;
        int j = -1;

        // Step 1: Find the index of the first zero
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) return;
        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroToEnd solution = new MoveZeroToEnd();

        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("Before: " + Arrays.toString(nums));

        solution.moveZeroes1(nums);

        System.out.println("After:  " + Arrays.toString(nums));
    }
}
