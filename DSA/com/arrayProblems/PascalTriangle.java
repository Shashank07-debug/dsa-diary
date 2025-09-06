package com.arrayProblems;

public class PascalTriangle {
    // TC - > O(r) SC -> O(1) this is first type of problem that takes row and col and return the element in that row and col
    public static int nthElement(int n, int r){
        int result = 1;
        for(int i = 0; i < r; i++){
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    //TC -> O(N) SC -> O(1)
    public static void nthRow(int n){
        int ans = 1;
        System.out.print(ans+" ");
        for(int i = 1; i < n; i++){
            ans = ans * (n - i);
            ans = ans / (i);
            System.out.print(ans+" ");
        }
        System.out.println();
    }

    // TC -> O(N ^ 2) SC -> O(1) Inorder to store result in list it would have taken O(N ^ 2) Space complexity
    public static void pascalTriangle(int n){
        for(int i = 1; i <= n; i++){
            nthRow(i);
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int r = 3;
        pascalTriangle(6);
        System.out.println("==========================");
        nthRow(6);
        int value = nthElement(n - 1, r - 1);
        System.out.println("==========================");
        System.out.println("Element at row " + n + ", position " + r + " is: " + value);
    }
}
