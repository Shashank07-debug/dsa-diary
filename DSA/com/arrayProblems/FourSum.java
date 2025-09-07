package com.arrayProblems;

import java.util.*;

public class FourSum {
    //Brute Force TC - > O(N ^ 4) SC -> SC  -> O(M) M is unique quadraple
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            Collections.sort(temp);
                            st.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(st);
    }

    //Better Approach TC - > O(N ^ 3) SC - > O(M) + O(N) = O(M + N)
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                Set<Long>hashSet = new HashSet<>();
                for(int k = j + 1; k < n; k++){
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long fourth = (long)target - sum;
                    if(hashSet.contains(fourth)){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int)fourth);
                        Collections.sort(temp);
                        st.add(temp);
                    }
                    hashSet.add((long)nums[k]);
                }
            }
        }
        return new ArrayList<>(st);
    }

    //Optimised Approach TC - > O(N ^ 3) SC -> O(1) if we consider output storage then its O(N)
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicates

                int k = j + 1, l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l]; // use long

                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        // skip duplicates
                        while (k < l && nums[k] == nums[k + 1]) k++;
                        while (k < l && nums[l] == nums[l - 1]) l--;

                        k++;
                        l--;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        FourSum solution = new FourSum();

        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> result = solution.fourSum(nums, target);

        System.out.println("Quadruplets that sum to " + target + ":");
        for (List<Integer> quad : result) {
            System.out.println(quad);
        }
    }
}
