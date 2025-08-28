package com.arrayProblems;

public class FindMissingNumber {
    // Brute Force | Time: O(n^2), Space: O(1)
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for(int i = 0; i <= n; i++){
            int flag = 0;
            for(int j = 0; j < n; j++){
                if(nums[j] == i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) return i;
        }
        return -1;
    }
    //Better Solution TC - > O(N) + O(N) SC -> O(N)
    public int missingNumber1(int[] nums) {
        int n = nums.length;
        int hash[] = new int[n + 1];
        for(int i = 0; i < n; i++){
            hash[nums[i]] = 1;
        }
        for(int i = 0; i <= n; i++){
            if(hash[i] == 0){
                return i;
            }
        }
        return -1;
    }


    //Optimal Solution 1  TC - > O(N)    SC - > O(1)
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = (n * (n + 1) )/2;
        int s2 = 0;
        for(int i = 0; i < n; i++){
            s2 += nums[i];
        }
        return sum - s2;
    }
    //Optimal Solution 2 TC - > O(N)    SC - > O(1)
    public int missingNumber3(int[] nums) {
        int n = nums.length;
        int xor1 = 0;
        int xor2 = 0;
        for(int i = 0; i < n; i++){
            xor2 = xor2 ^ (nums[i]);
            xor1 = xor1 ^ (i + 1);
        }
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        FindMissingNumber obj = new FindMissingNumber();
        int[] nums = {3, 0, 1};
        System.out.println(obj.missingNumber(nums));
    }
}
