package com.arrayProblems;

public class SecondLargestBrute {
        static void qs(int[] nums, int low, int high){
            if(low < high){
                int partition = sort(nums, low, high);
                qs(nums, low, partition - 1);
                qs(nums, partition + 1, high);
            }
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

        public int secondLargestElement(int[] nums) {
            qs(nums, 0, nums.length - 1);
            int largest = nums[nums.length - 1];
            int slargest = -1;
            for(int i = nums.length - 2; i >= 0; i--){
                if(nums[i] > slargest && nums[i] < largest){
                    slargest = nums[i];
                    break;
                }
            }
            return slargest;
        }

        public static void main(String[] args) {
            SecondLargestBrute sol = new SecondLargestBrute();

            int[] arr1 = {3, 1, 5, 2, 4};
            int[] arr2 = {10, 10, 9, 8};
            int[] arr3 = {7, 7, 7};

            System.out.println("Second largest in arr1: " + sol.secondLargestElement(arr1)); // 4
            System.out.println("Second largest in arr2: " + sol.secondLargestElement(arr2)); // 9
            System.out.println("Second largest in arr3: " + sol.secondLargestElement(arr3)); // -1
        }
}

