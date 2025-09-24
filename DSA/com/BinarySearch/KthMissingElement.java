package com.BinarySearch;

public class KthMissingElement {
    //TC -> O(N) SC -> O(1)
    public int findKthPositive(int[] arr, int k) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= k) k++;
            else break;
        }
        return k;
    }

    //TC -> O(LogN) SC -> O(1)
    public int findKthPositive1(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k)low = mid + 1;
            else high = mid - 1;
        }
        return (high + 1 + k);
    }

    public static void main(String[] args) {
        KthMissingElement solver = new KthMissingElement();

        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        // O(N) solution
        int result1 = solver.findKthPositive(arr, k);
        System.out.println("O(N) approach result: " + result1);

        // O(LogN) solution
        int result2 = solver.findKthPositive1(arr, k);
        System.out.println("O(LogN) approach result: " + result2);
    }
}
