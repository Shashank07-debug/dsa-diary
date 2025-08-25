package com.arrayProblems;

import java.util.ArrayList;

public class CheckSorted {

    public boolean isSorted(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckSorted sol = new CheckSorted();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        list2.add(3);
        list2.add(1);
        list2.add(4);

        list3.add(7);

        System.out.println("list1 is sorted? " + sol.isSorted(list1)); // true
        System.out.println("list2 is sorted? " + sol.isSorted(list2)); // false
        System.out.println("list3 is sorted? " + sol.isSorted(list3)); // true
    }
}

