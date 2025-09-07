package com.arrayProblems;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithXorK {
    //Brute Force Approach TC - > O(N ^ 3) SC -> O(1)
    public int subarraysWithXorK(int[] nums, int p) {
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int xor = 0;
                for (int k = i; k <= j; k++) {
                    xor = xor ^ nums[k];
                }
                if (xor == p) cnt++;
            }
        }
        return cnt;
    }

    //Better Approach TC -> O(N ^ 2) SC -> O(1)
    public int subarraysWithXorK1(int[] nums, int p) {
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor ^= nums[j];
                if (xor == p) cnt++;
            }
        }
        return cnt;
    }

    //Optimal Solution TC -> O(N) SC -> O(N)
    public int subarraysWithXorK2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int prefixXor = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            prefixXor ^= nums[i];
            int target = prefixXor ^ k;
            cnt += map.getOrDefault(target, 0);
            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        SubarraysWithXorK sol = new SubarraysWithXorK();

        int[] nums1 = {4, 2, 2, 6, 4};
        int p1 = 6;
        System.out.println("Count (nums1, p1): " + sol.subarraysWithXorK(nums1, p1));
        // Expected: 4

        int[] nums2 = {5, 6, 7, 8, 9};
        int p2 = 5;
        System.out.println("Count (nums2, p2): " + sol.subarraysWithXorK(nums2, p2));
        // Expected: 2

        int[] nums3 = {1, 2, 3};
        int p3 = 0;
        System.out.println("Count (nums3, p3): " + sol.subarraysWithXorK(nums3, p3));
        // Expected: 0
    }
}
