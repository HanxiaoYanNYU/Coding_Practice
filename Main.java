package Leetcode;

import Leetcode.Binary_Search.Easy.*;
import Leetcode.Binary_Search.Medium.*;

public class Main {

    public static void main(String[] args) {
        int[] re = Find_First_Last_Elements_in_Sorted_Array_34.searchRange(new int[]{2,2}, 2);
        for (Integer i : re) {
            System.out.println(i);
        }
    }
}
