package Leetcode.Binary_Search.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Is_Subsequence_392 {

    /**
     * My solution, straight solution, use String.indexOf(char, int)
     * 2ms and beat 94%
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;

        int index = 0;
        for (char ss : s.toCharArray()) {
            index = t.indexOf(ss, index); // Find the first occurrence of this char in String t starting from index
            if (index == -1) return false;
            index++;
        }
        return true;
    }

    /**
     * My solution, use HashMap and Binary Search
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence_1(String s, String t) {
        if (s == null) return true;
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) map.get(t.charAt(i)).add(i);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(t.charAt(i), list);
            }
        }

        int prev = -1;
        for (char ss : s.toCharArray()) {
            int index = binarysearch(prev, map.get(ss));
            if (index == -1) return false;
            else prev = index;
        }
        return true;
    }

    /*
     Return the left most element in this list which is greater than prev
     [0,1,2,3,4], prev= 1, then return 2.
     */
    public static int binarysearch(int prev, List<Integer> list) {
        if (list == null || list.get(list.size()-1) <= prev) return -1;

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= prev) left = mid + 1;
            else right = mid;
        }
        return list.get(left);
    }

    /**
     * LeetCode solution, two pointer, O(n), 37ms and beat 31%
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence_lc(String s, String t) {
        if (s == null || s.length() == 0) return true;

        int pointerS = 0;
        int pointerT = 0;

        while (pointerT < t.length()) {
            if (s.charAt(pointerS) == t.charAt(pointerT)) {
                pointerS++;
            }
            if (pointerS == s.length()) return true;
            pointerT++;
        }

        return false;
    }
}
