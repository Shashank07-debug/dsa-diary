package com.arrayProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElement {
    //Brute Force Approach TC - > O(n ^ 2)  SC - > O(1)
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) cnt++;
            }
            if (cnt > (n / 2)) return nums[i];
        }
        return -1;
    }

    //Better Approach TC -> O(N) SC -> O(N)
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 2) return key;
        }
        return -1;
    }


    //Optimal Solution Boyer-Moore Voting Algorithm TC - > O(N) SC -> O(1)
    public int majorityElement3(int[] nums) {
        int cnt = 0;
        int ele = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                cnt = 1;
                ele = nums[i];
            } else if (nums[i] == ele) {
                cnt++;
            } else {
                cnt--;
            }
        }
        int cnt1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele) {
                cnt1++;
            }
        }
        if (cnt1 > nums.length / 2) return ele;
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 2, 3, 3, 3};

        MajorityElement solution = new MajorityElement();
        int result = solution.majorityElement3(nums);

        if (result != -1) {
            System.out.println("The majority element is: " + result);
        } else {
            System.out.println("There is no majority element.");
        }

    }
}
