package com.BinarySearch;

import java.util.Arrays;

public class AllocateBooks {
    // TC - > O(SUM - MAX + 1) * O(N) SC -> O(1)
    public int findPages(int[] nums, int m) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        for (int i = low; i <= high; i++) {
            int cntStudent = fun(nums, i);
            if (cntStudent <= m) {
                return i;
            }
        }
        return -1;
    }

    private static int fun(int[] nums, int pages) {
        int students = 1;
        int cntPages = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cntPages + nums[i] <= pages) {
                cntPages += nums[i];
            } else {
                students++;
                cntPages = nums[i];
            }
        }
        return students;
    }

    //Optimal Approach TC -> O(log(sum - max + 1)) * O(n) SC -> O(1)
    public int findPages1(int[] nums, int m) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        int result = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            int cntStudents = fun(nums, mid);
            if(cntStudents <= m){
                result = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AllocateBooks allocator = new AllocateBooks();

        int[] books1 = {12, 34, 67, 90};
        int students1 = 2;
        System.out.println("Minimum maximum pages: " + allocator.findPages(books1, students1));

        int[] books2 = {10, 20, 30, 40};
        int students2 = 2;
        System.out.println("Minimum maximum pages: " + allocator.findPages(books2, students2));

        int[] books3 = {5, 17, 100, 11};
        int students3 = 4;
        System.out.println("Minimum maximum pages: " + allocator.findPages(books3, students3));
    }
}
