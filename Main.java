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
        boolean res = Is_Subsequence_392.isSubsequence_1("eeee",
                "eee");
        System.out.println(res);

    }
    public int hIndex(int[] citations) {
        int len = citations.length;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int med = (hi + lo) / 2;
            if (citations[med] == len - med) {
                return len - med;
            } else if (citations[med] < len - med) {
                lo = med + 1;
            } else {
                //(citations[med] > len-med), med qualified as a hIndex,
                // but we have to continue to search for a higher one.
                hi = med - 1;
            }
        }
        return len - lo;
    }
}
