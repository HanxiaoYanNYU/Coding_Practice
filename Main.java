package Leetcode;

import Leetcode.Binary_Search.Easy.*;
import Leetcode.Binary_Search.Medium.*;
import Leetcode.Google.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int res = Kth_Smallest_Element_in_Sorted_Matrix_378.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}},7);
        System.out.println(res);
    }
}
