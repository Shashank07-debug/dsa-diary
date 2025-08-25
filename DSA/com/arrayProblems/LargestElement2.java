package com.arrayProblems;
// This is optimal Approach TC - > O(N) SC - > O(1)
public class LargestElement2 {
    static int largestElement(int[] arr){
        int largest = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        LargestElement sol = new LargestElement();
        int[] arr = {3, 1, 5, 2, 9};
        System.out.println("Largest element: " + sol.largestElement(arr));
    }
}
