package com.arrayProblems;

import java.util.Arrays;

public class MergeSortedArrays {
    //Optimal Solution1 TC - > O(N) + O(NLogN) + O(MLogM)  SC -> O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = 0;
        while(left >=0 && right < n){
            if(nums1[left] > nums2[right]){
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
            }
            left--;
            right++;
        }
        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);
        for(int i = 0; i < n; i++){
            nums1[i + m] = nums2[i];
        }
    }

    //Optimal Solution2 TC - > O(log(m + n)) + O(m + n)  SC -> O(1)
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int gap = (len / 2) + (len % 2);
        while(gap > 0){
            int left =  0;
            int right = left + gap;
            while(right < len){
                if(left < m && right >= m){
                    swapIfGreater(nums1, nums2, left, right - m);
                }else if(left >= m){
                    swapIfGreater(nums2, nums2, left - m, right - m);
                }else{
                    swapIfGreater(nums1, nums1, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1)break;
            gap = (gap / 2) + (gap % 2);
        }
        for(int i = 0; i < n; i++){
            nums1[m + i] = nums2[i];
        }
    }

    public static void swapIfGreater(int[] nums1, int[] nums2, int left, int right){
        if(nums1[left] > nums2[right]){
            int temp  = nums1[left];
            nums1[left] = nums2[right];
            nums2[right] = temp;
        }
    }
    public static void main(String[] args) {
        MergeSortedArrays solution = new MergeSortedArrays();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        solution.merge(nums1, m, nums2, n);

        System.out.println("Merged array: " + Arrays.toString(nums1));
    }
}
