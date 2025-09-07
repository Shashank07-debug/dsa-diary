package com.arrayProblems;

import java.util.Arrays;
import java.util.*;

public class ThreeSum {
    //Brute Force Approach TC - > O(N ^ 3) SC - > 2 * O(M) number of triplets is M
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    //Better Approach TC - > O(N ^ 2)   SC - > O(N) + O(M) O(N)to store each element and O(M) will be the number of triplets
    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            Set<Integer> hashset = new HashSet<>();
            for(int j = i + 1; j < n; j++){
                int third = -(nums[i] + nums[j]);
                if(hashset.contains(third)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);
                    Collections.sort(temp);
                    st.add(temp);
                }
                hashset.add(nums[j]);
            }
        }
        return new ArrayList<>(st);
    }

    //Optimal Approach TC - > O(N Log N) + O(N ^ 2) SC -> O(1) + O(M) if we want to count the storing also then we will have space complexity of SC - > O(logN) + O(M)
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1])continue;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                }else if(sum > 0){
                    k--;
                }else{
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j + 1])j++;
                    while(j < k && nums[k] == nums[k - 1])k--;
                    j++;
                    k--;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Triplets: " + sol.threeSum(nums1));

        int[] nums2 = {0, 1, 1};
        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Triplets: " + sol.threeSum(nums2));

        int[] nums3 = {0, 0, 0};
        System.out.println("\nInput: " + Arrays.toString(nums3));
        System.out.println("Triplets: " + sol.threeSum(nums3));
    }
}
