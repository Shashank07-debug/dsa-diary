package com.arrayProblems;
// Using Sorting Algorithm TC - > O(NlogN) SC - > O(1)
public class LargestElement {
        static int qs(int[] nums, int low , int high){
            if(low < high){
                int partition = sort(nums, low, high);
                qs(nums, low, partition - 1);
                qs(nums, partition + 1, high);
            }
            return nums[nums.length - 1];
        }

        static int sort(int[] nums, int low, int high){
            int pivot = nums[low];
            int i = low;
            int j = high;
            while(i < j){
                while(i <= high && nums[i] <= pivot) i++;
                while(j >= low && nums[j] > pivot) j--;
                if(i < j){
                    swap(nums, i, j);
                }
            }
            swap(nums, low, j);
            return j;
        }

        static void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public int largestElement(int[] nums) {
            int res = qs(nums, 0, nums.length - 1);
            return res;
        }

        public static void main(String[] args) {
            LargestElement sol = new LargestElement();
            int[] arr = {3, 1, 5, 2, 4};
            System.out.println("Largest element: " + sol.largestElement(arr));
        }
    }

