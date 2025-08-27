package com.arrayProblems;
import java.util.*;
public class UnionOfArray {
    //Brute Force Approach TC -> O(n1) + O(n2) SC -> O(n1) + O(n2)
    public int[] unionArray(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums1) set.add(num);

        for (int num : nums2) set.add(num);

        int[] res = new int[set.size()];
        int i = 0;
        for (int value : set) res[i++] = value;

        return res;
    }
    //Optimal Approach TC -> 0(n) + O(m)   SC -> 0(n) + O(m) not to solve problem but the space complexity is to return the answer
    public int[] unionArray1(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;
        ArrayList<Integer> arr = new ArrayList<>();
        while(i < n && j < m){
            if(nums1[i] <= nums2[j]){
                if(arr.size() == 0 || arr.get(arr.size()-1) != nums1[i]){
                    arr.add(nums1[i]);
                }
                i++;
            }else{
                if(arr.size() == 0 || arr.get(arr.size()-1) != nums2[j]){
                    arr.add(nums2[j]);
                }
                j++;
            }
        }
        while(i < n){
            if(arr.get(arr.size() - 1) != nums1[i])
                arr.add(nums1[i]);
            i++;
        }
        while(j < m){
            if(arr.get(arr.size() - 1) != nums2[j])
                arr.add(nums2[j]);
            j++;
        }
        int[] res = new int[arr.size()];
        for(int k = 0; k < arr.size(); k++){
            res[k] = arr.get(k);
        }
        return res;
    }

    public static void main(String[] args) {
        UnionOfArray solution = new UnionOfArray();

        int[] nums1 = {1, 2, 2, 3};
        int[] nums2 = {2, 3, 4, 5};

        int[] union = solution.unionArray1(nums1, nums2);

        System.out.println("Union of arrays: " + Arrays.toString(union));
    }
}
