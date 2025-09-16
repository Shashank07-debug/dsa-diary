package com.BinarySearch;

public class FindPeakElement {
    //TC -> O(N) SC -> O(1)
    public int findPeakElement(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            boolean leftOK = (i == 0) || (nums[i - 1] < nums[i]);
            boolean rightOK = (i == nums.length - 1) || (nums[i] > nums[i+ 1]);
            if(leftOK && rightOK){
                return i;
            }

        }
        return -1;
    }

    //TC -> O(logN) SC -> O(1)
    public int findPeakElement1(int[] nums) {
        int n = nums.length;
        if(n == 1)return 0;
        if(nums[0] > nums[1])return 0;
        if(nums[n - 1] > nums[n - 2])return n - 1;
        int low = 1;
        int high = n - 2;
        while(low <= high){
            int mid = (low + high) / 2;
            if((nums[mid] > nums[mid - 1]) && (nums[mid] > nums[mid + 1])){
                return mid;
            }else if(nums[mid] > nums[mid - 1]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        FindPeakElement finder = new FindPeakElement();

        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        int[] nums3 = {10}; // single element case

        System.out.println("Peak index in nums1: " + finder.findPeakElement(nums1)); // expected 2
        System.out.println("Peak index in nums2: " + finder.findPeakElement(nums2)); // expected 1 or 5
        System.out.println("Peak index in nums3: " + finder.findPeakElement(nums3)); // expected 0
    }
}
