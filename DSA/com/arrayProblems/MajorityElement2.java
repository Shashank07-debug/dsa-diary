package com.arrayProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {

    //Brute Force Approach TC -> O(N ^ 2) SC - > O(1) EvenTough It is list but it stores only 2 elements so O(2) effectively O(1)
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int cnt = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[i] == nums[j]) cnt++;
            }
            if(cnt > Math.floor(nums.length / 3) && !ans.contains(nums[i])){
                ans.add(nums[i]);
            }
            if(ans.size() == 2)break;
        }
        return ans;
    }

    //Better Approach TC -> O(N) SC -> O(N)
    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) > Math.floor(nums.length / 3)){
                ans.add(key);
            }
        }
        return ans;
    }

    //Optimal Approach TC -> O(N) SC -> O(1)
    public List<Integer> majorityElement3(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0;
        int ele1 = 0, ele2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(cnt1 == 0 && ele2 != nums[i]){
                cnt1 = 1;
                ele1 = nums[i];
            }
            else if(cnt2 == 0 && ele1 != nums[i]){
                cnt2 = 1;
                ele2 = nums[i];
            }
            else if(ele1 == nums[i]) cnt1++;
            else if(ele2 == nums[i]) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(ele1 == nums[i]) cnt1++;
            if(ele2 == nums[i]) cnt2++;
        }
        int mini = (nums.length / 3);
        if(cnt1 > mini && !ans.contains(ele1)) ans.add(ele1);
        if(cnt2 > mini && !ans.contains(ele2)) ans.add(ele2);
        return ans;
    }

    public static void main(String[] args) {
        MajorityElement2 obj = new MajorityElement2();

        int[] nums1 = {3, 2, 3};
        System.out.println("Input: [3, 2, 3] -> Output: " + obj.majorityElement(nums1));

        int[] nums2 = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println("Input: [1, 1, 1, 3, 3, 2, 2, 2] -> Output: " + obj.majorityElement(nums2));

        int[] nums3 = {2, 2, 9, 9, 9, 2, 2};
        System.out.println("Input: [2, 2, 9, 9, 9, 2, 2] -> Output: " + obj.majorityElement(nums3));
    }
}
