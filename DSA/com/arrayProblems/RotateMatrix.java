package com.arrayProblems;

public class RotateMatrix {
    // Brute Force Solution TC - > O(N^2) + O(N ^ 2) SC - > O(N ^ 2)
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][(n - 1) - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }

    //Optimal Approach TC -> O(N /2 * N /2) + O(N * N / 2) = O(N ^ 2) SC - > O(13)
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            reverse(matrix, i);
        }
    }
    public static void reverse(int[][] matrix, int i){
        int left = 0;
        int right = matrix.length - 1;
        while(left < right){
            int temp = matrix[i][left];
            matrix[i][left] = matrix[i][right];
            matrix[i][right] = temp;
            left++;
            right--;
        }
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }



    public static void main(String[] args) {
        RotateMatrix obj = new RotateMatrix();

        // Example matrix
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        obj.rotate2(matrix);

        System.out.println("Rotated Matrix (90° clockwise):");
        printMatrix(matrix);
    }
}
