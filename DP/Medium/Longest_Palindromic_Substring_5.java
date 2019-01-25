package Leetcode.DP.Medium;

public class Longest_Palindromic_Substring_5 {

    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        boolean[][] isPalindromic = new boolean[s.length()][s.length()];

        int maxLen = 1;
        String res = s.substring(0, 1);
        for (int dist = 1; dist < s.length(); dist++) {
            for (int start = 0; start < s.length() - dist; start++) {
                int end = start + dist;
                isPalindromic[start][end] = s.charAt(start) == s.charAt(end) &&
                        (dist <= 2 || isPalindromic[start + 1][end - 1]);

                if (isPalindromic[start][end] && (dist + 1) > maxLen) res = s.substring(start, end + 1);
            }
        }

        return res;
    }
}
