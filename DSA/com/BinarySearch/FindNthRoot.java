package com.BinarySearch;

import java.util.Scanner;

public class FindNthRoot {
    private int func(int mid, int M, int N) {
        long ans = 1;
        for (int i = 1; i <= N; i++) {
            ans *= mid;
            if (ans > M) return 2; // too large
        }
        if (ans < M) return 1; // too small
        return 0; // exact
    }

    public int NthRoot(int N, int M) {
        int low = 1;
        int high = M;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = func(mid, M, N);
            if (midN == 0) return mid;
            else if (midN == 1) low = mid + 1;
            else high = mid - 1;
        }
        return -1; // no integer root exists
    }

    public static void main(String[] args) {
        FindNthRoot solver = new FindNthRoot();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N (root): ");
        int N = sc.nextInt();
        System.out.print("Enter M (number): ");
        int M = sc.nextInt();

        int result = solver.NthRoot(N, M);
        if (result == -1)
            System.out.println("No integer " + N + "th root exists for " + M);
        else
            System.out.println("The " + N + "th root of " + M + " is: " + result);

        // Example test cases
        System.out.println("\nSample Runs:");
        System.out.println("NthRoot(3, 27) = " + solver.NthRoot(3, 27)); // 3
        System.out.println("NthRoot(2, 16) = " + solver.NthRoot(2, 16)); // 4
        System.out.println("NthRoot(2, 8)  = " + solver.NthRoot(2, 8));  // -1
        System.out.println("NthRoot(5, 243)= " + solver.NthRoot(5, 243)); // 3
        System.out.println("NthRoot(4, 15) = " + solver.NthRoot(4, 15)); // -1
    }
}
