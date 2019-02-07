package Leetcode.Guidewire;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        int[] A = {10, 1, 3, 15, 30, 40, 4, 50, 2, 1};
//
//        int res = solution_2(A, 3, 3);
//        System.out.println(res);

        String res2 = compress("aaabbbcdd");
        System.out.println(res2);
    }

    /**
     * Season amplitude problem
     * @param T
     * @return
     */
    public static String solution(int[] T) {
        // write your code in Java SE 8

        int yearLen = T.length;
        int seasonLen = yearLen / 4;
        String[] season = {"WINTER", "SPRING", "SUMMER", "AUTUMN"};
        String result = "";

        int maxAmplitude = -1;
        for (int i = 0; i < 4; i++) {
            int amplitude = findMaxAmp(T, i*seasonLen, seasonLen);
            if (amplitude > maxAmplitude) {
                result = season[i];
                maxAmplitude = amplitude;
            }
        }
        return result;
    }

    private static int findMaxAmp(int[] T, int start, int seasonLen) {
        int[] thisSeason = new int[seasonLen];
        for (int i = 0; i < seasonLen; i++) {
            thisSeason[i] = T[i + start];
        }
        Arrays.sort(thisSeason);
        return thisSeason[seasonLen-1] - thisSeason[0];
    }

    /**
     * Collect fruit problem
     * @param A
     * @param K
     * @param L
     * @return
     */
    public static int solution_2(int[] A, int K, int L) {
        // write your code in Java SE 8
        if (K + L > A.length) return -1;

        int maxCollect = -1;

        for (int aliceStart = 0; aliceStart <= A.length - K; aliceStart++) {
            int bobMaxCollect = Math.max(collect(A, 0, aliceStart - 1, L),
                                      collect(A, aliceStart + K, A.length - 1, L));
            int aliceMaxCollect = collect(A, aliceStart, aliceStart + K - 1, K);
            maxCollect = Math.max(maxCollect, bobMaxCollect + aliceMaxCollect);
        }
        return maxCollect;
    }

    private static int collect(int[] A, int left, int right, int Len) {
        if (left + Len - 1 > right) return 0;

        int maxCollect = -1;
        int collect = 0;
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (count < Len) {
                collect += A[i];
                count++;
            } else {
                // count == L
                maxCollect = Math.max(maxCollect, collect);
                collect = collect + A[i] - A[i-Len];
            }
        }
        maxCollect = Math.max(maxCollect, collect);
        return maxCollect;
    }

    /**
     * Compress string
     * @param s
     * @return
     */
    public static String compress(String s) {
        if (s == null || s.length() == 0) return s;

        char[] c = s.toCharArray();
        int start = 0;
        int end;
        int count = 0;
        String res = "";

        for (end = 0; end < c.length; end++) {
            if (c[start] == c[end]) count++;
            else {
                if (count == 1) res += c[start];
                else res += c[start] + Integer.toString(count);
                count = 1;
                start = end;
            }
        }
        if (count == 1) res += c[start];
        else res += c[start] + Integer.toString(count);

        return res;
    }
}
