package com.arrayProblems;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RearrangeTheArray {
    //Brute Force Solution TC -> O(2N) SC -> O(N)
    public int[] rearrangeArray(int[] nums){
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];
        int k = 0;
        int l = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                pos[k] = nums[i];
                k++;
            }else{
                neg[l] = nums[i];
                l++;
            }
        }
        for(int i = 0; i < nums.length / 2; i++){
            nums[2 * i] = pos[i];
            nums[2 * i + 1] = neg[i];
        }
        return nums;
    }

    // Optimal Solution TC -> O(N) SC -> O(N)
    public int[] rearrangeArray1(int[] nums) {
        int[] ans = new int[nums.length];
        int k = 0;
        int l = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                ans[l] = nums[i];
                l += 2;
            } else {
                ans[k] = nums[i];
                k += 2;
            }
        }
        return ans;
    }

    //Another version which is having uneven numbers of positive elements and negative elements
    //TC - > O() SC -> O(N)

    public int[] rearrangeArray2(int[] nums){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                pos.add(nums[i]);
            }else{
                neg.add(nums[i]);
            }
        }

        if(pos.size() > neg.size()){
            for(int i = 0; i < neg.size(); i++){
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }
            int idx = neg.size() * 2;
            for(int i = neg.size(); i < pos.size(); i++){
                nums[idx] = pos.get(i);
                idx++;
            }
        }else{
            for(int i = 0; i < pos.size(); i++){
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }
            int idx = pos.size() * 2;
            for(int i = pos.size(); i < neg.size(); i++){
                nums[idx] = neg.get(i);
                idx++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        RearrangeTheArray solution = new RearrangeTheArray();

        int[] nums = {3, -2, 1, -5, 2, -4};
        int[] result = solution.rearrangeArray2(nums);

        System.out.print("Rearranged Array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
