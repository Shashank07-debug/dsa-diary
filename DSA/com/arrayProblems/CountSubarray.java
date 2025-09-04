package com.arrayProblems;

import java.util.HashMap;
import java.util.Map;

public class CountSubarray {
    //Brute Force Approach TC - > O(N ^ 3) SC - > O(1)
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int sum = 0;
                for(int l = i; l <= j; l++){
                    sum += nums[l];
                }
                if(sum == k){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    //Better Approach TC - > O(N ^ 2) SC - > O(1)
    public static int subarraySum1(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                if(sum == k){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    //Optimal Solution TC - > O(N) SC- > O(N)
    public int subarraySum3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int cnt = 0;
        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            int remove = prefixSum - k;
            cnt += map.getOrDefault(remove, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return cnt;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 3;
        System.out.println(subarraySum1(arr, k)); // Output: 2
    }
}
