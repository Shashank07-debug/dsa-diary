package com.arrayProblems;

import java.util.ArrayList;
import java.util.Collections;

public class LeaderInArray {
    //Brute Force Approach TC - > O(N ^ 2)  SC - > O(N)
    public ArrayList<Integer> leaders(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n - 1; i++){
            boolean leader = true;
            for(int j = i + 1; j < n; j++){
                if(nums[j] > nums[i]){
                    leader = false;
                    break;
                }
            }
            if(leader == true){
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    //Optimal Solution TC -> O(N) SC -> O(N)
    public ArrayList<Integer> leaders1(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        for(int i = n -1; i >= 0; i--){
            if(nums[i] > maxi){
                ans.add(nums[i]);
            }
            maxi = Math.max(maxi, nums[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {
        LeaderInArray solution = new LeaderInArray();

        int[] nums = {16, 17, 4, 3, 5, 2};

        ArrayList<Integer> leadersList = solution.leaders(nums);

        System.out.println("Leaders in the array: " + leadersList);
    }
}
