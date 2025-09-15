package com.BinarySearch;

import java.util.ArrayList;

public class FindKRotation {
    //TC -> O(LogN)  SC -> O(1)
    public int findKRotation(ArrayList<Integer> nums) {
        int low = 0;
        int high = nums.size() - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Case: subarray already sorted
            if (nums.get(low) <= nums.get(high)) {
                if (nums.get(low) < ans) {
                    ans = nums.get(low);
                    index = low;
                }
                break;
            }

            // Left half is sorted
            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) < ans) {
                    ans = nums.get(low);
                    index = low;
                }
                low = mid + 1;
            }
            // Right half is sorted
            else {
                if (nums.get(mid) < ans) {
                    ans = nums.get(mid);
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index; // ✅ return index of minimum element (rotation count)
    }

    // ✅ Main for testing
    public static void main(String[] args) {
        FindKRotation obj = new FindKRotation();
        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(15); nums1.add(18); nums1.add(2); nums1.add(3); nums1.add(6); nums1.add(12);

        System.out.println("K rotations: " + obj.findKRotation(nums1)); // Expected 2

        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(7); nums2.add(9); nums2.add(11); nums2.add(12); nums2.add(5);

        System.out.println("K rotations: " + obj.findKRotation(nums2)); // Expected 4

        ArrayList<Integer> nums3 = new ArrayList<>();
        nums3.add(1); nums3.add(2); nums3.add(3); nums3.add(4);

        System.out.println("K rotations: " + obj.findKRotation(nums3)); // Expected 0
    }
}
