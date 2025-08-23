package com.sortingAlgos;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveBubbleSort {
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
        sort(arr, n);
        return arr;
    }
    static void sort(int[] arr, int n){
        if(n == 1) return;
        for(int j = 0; j <= n - 2; j++){
            if(arr[j + 1] < arr[j]){
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
        }
        sort(arr, n- 1);
    }
}
