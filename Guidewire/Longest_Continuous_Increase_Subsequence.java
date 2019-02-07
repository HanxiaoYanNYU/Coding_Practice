package Leetcode.Guidewire;

public class Longest_Continuous_Increase_Subsequence {

    public static int[] LCS(int[] input) {
        if (input == null || input.length == 0) return new int[0];
        if (input.length == 1) return input;

        int[] memo = new int[input.length];
        for (int i = 0; i < memo.length; i++) memo[i] = 1;

        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i-1]) memo[i] = memo[i-1] + 1;
        }

        int maxLen = -1;
        int index = -1;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] > maxLen) {
                maxLen = memo[i];
                index = i;
            }
        }

        int[] res = new int[maxLen];
        for (int i = 0; i < maxLen; i++) {
            res[i] = input[index - maxLen + 1 + i];
        }

        return res;
    }

    public static int[] LCS_solu2(int[] input) {
        if (input == null || input.length == 0) return new int[0];
        if (input.length == 1) return input;

        int end = 0;
        int maxLen = -1;
        int len = 1;

        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i-1]) {
                len++;
            } else {
                if (len > maxLen) {
                    end = i - 1;
                    maxLen = len;
                }
                len = 1;
            }
        }
        if (len > maxLen) {
            end = input.length - 1;
            maxLen = len;
        }

        int[] res = new int[maxLen];
        for (int i = 0; i < maxLen; i++) {
            res[i] = input[end - maxLen + 1 + i];
        }
        return res;
    }
}
