package com.sortingAlgos;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Enter " + i + " element : ");
            arr[i] = sc.nextInt();
        }
        int[] res = bubbleSort(arr, n);
        System.out.println(Arrays.toString(res));
    }

    static int[] bubbleSort(int[] arr, int n){
        int didSwap = 0;
        for(int i = n - 1; i >= 1; i--){
            for(int j = 0; j <= i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    didSwap = 1;
                }
            }
            // Little Optimization for Best Case
            if(didSwap == 0) break;
        }
        return arr;
    }
}
