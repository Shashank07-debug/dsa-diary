package com.arrayProblems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    //Optimal Solution TC - > O(N * M) SC - > O(N * M)
    public List<Integer> spiralOrder(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = m -1;
        int top = 0, bottom = n - 1;
        List<Integer> ans = new ArrayList<>();
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i <= bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom){
                for(int i = right; i>= left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4, m = 4; // matrix size
        int[][] spiralForm = new int[n][m];

        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                spiralForm[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                spiralForm[i][right] = num++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    spiralForm[bottom][i] = num++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiralForm[i][left] = num++;
                }
                left++;
            }
        }

        System.out.println("Spiral form of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%3d ", spiralForm[i][j]);
            }
            System.out.println();
        }
    }
}
