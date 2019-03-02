package Leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning_131 {

    /**
     * Accepted solution
     * @param s
     * @return
     */
    public List<List<String>> partition_ac(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;

        findPartition(res, new ArrayList<>(), s);
        return res;
    }

    private void findPartition(List<List<String>> res, List<String> track, String s) {
        if (s.equals("")) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String part = s.substring(0, i);
            if (isPalindrome(part)) {
                track.add(part);
                findPartition(res, track, s.substring(i));
                track.remove(track.size()-1);
            }
        }
    }

    /**
     * Correct elements but incorrect order, Not Accepted by LeetCode
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;

        for (int i = 0; i <= s.length()-1; i++) {
            // i is the number of cuts we make on string
            findPartition(res, new ArrayList<>(), s, i);
        }
        return res;
    }

    private void findPartition(List<List<String>> res, List<String> track, String s, int numOfCuts) {
        if (numOfCuts == 0) {
            if (isPalindrome(s)) {
                track.add(s);
                res.add(new ArrayList<>(track));
                track.remove(track.size()-1);
            }
            return;
        }

        for (int i = 1; i < s.length(); i++) {
            String part = s.substring(0, i);
            if (isPalindrome(part)) {
                track.add(part);
                findPartition(res, track, s.substring(i), numOfCuts-1);
                track.remove(part);
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.equals("") || s.length() == 0) return false;
        if (s.length() == 1) return true;
        char[] c = s.toCharArray();
        int i = 0;
        int j = c.length - 1;
        while (i < j) {
            if (c[i] != c[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome_Partitioning_131 m = new Palindrome_Partitioning_131();
        List<List<String>> res = m.partition("abbab");
        for (List<String> list : res) {
            System.out.println(list);
        }
    }
}
