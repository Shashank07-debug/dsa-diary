package com.sortingAlgos;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Enter " + i + " element : ");
            arr[i] = sc.nextInt();
        }
        int[] res = selectionSort(arr, n);
        System.out.println(Arrays.toString(res));
    }
    static int[] selectionSort(int[] arr, int n){
        for(int i = 0 ; i <= n-2; i++){
            int mini = i;
            for(int j = i; j <= n-1; j++){
                if(arr[j] < arr[mini])
                    mini = j;
            }
            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;
        }
        return arr;

    }
}
