package com.BinarySearch;

public class FloorAndCeilElement {
    public int[] getFloorAndCeil(int[] nums, int x) {
        int[] ans = new int[2];
        int floorElement = floor(nums, x);
        int ceilElement = ceil(nums, x);
        ans[0] = floorElement;
        ans[1] = ceilElement;
        return ans;
    }

    private static int floor(int[] nums, int x) {
        int ans = -1;
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= x) {
                ans = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static int ceil(int[] nums, int x) {
        int ans = -1;
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= x) {
                ans = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FloorAndCeilElement obj = new FloorAndCeilElement();
        int[] nums = {1, 2, 4, 6, 8, 10};

        int x1 = 5;
        int[] result1 = obj.getFloorAndCeil(nums, x1);
        System.out.println("For " + x1 + " -> Floor: " + result1[0] + ", Ceil: " + result1[1]);

        int x2 = 0;
        int[] result2 = obj.getFloorAndCeil(nums, x2);
        System.out.println("For " + x2 + " -> Floor: " + result2[0] + ", Ceil: " + result2[1]);

        int x3 = 12;
        int[] result3 = obj.getFloorAndCeil(nums, x3);
        System.out.println("For " + x3 + " -> Floor: " + result3[0] + ", Ceil: " + result3[1]);
    }
}
