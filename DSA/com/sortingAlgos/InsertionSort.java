package com.sortingAlgos;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Enter " + i + " element : ");
            arr[i] = sc.nextInt();
        }
        int[] res = insertionSort(arr, n);
        System.out.println(Arrays.toString(res));
    }

    static int[] insertionSort(int[] arr, int n){
        for(int i = 0; i <= n -1; i++){
            int j = i;
            while(j > 0 && (arr[j - 1] > arr[j])){
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        return arr;
    }
}
