package Leetcode.Guidewire;

public class Zipcode {

    public static String zipcode(String A, String B) {
        if (A == null || A.length() == 0) return B;
        if (B == null || B.length() == 0) return A;

        String C = "";
        int minLen = Math.min(A.length(), B.length());
        for (int i = 0; i < 2 * minLen; i++) {
            if (i % 2 == 0) {
                C += A.charAt(i/2);
            } else {
                C += B.charAt((i-1)/2);
            }
        }
        if (Math.max(A.length(), B.length()) == minLen) return C;
        else return C += A.length() == minLen ? B.substring(minLen) : A.substring(minLen);
    }

    public static String zipcode_solu2(String A, String B) {
        if (A == null || A.length() == 0) return B;
        if (B == null || B.length() == 0) return A;

        String C = "";
        int minLen = Math.min(A.length(), B.length());
        for (int i = 0; i < minLen; i++) {
            C += A.charAt(i);
            C += B.charAt(i);
        }

        if (Math.max(A.length(), B.length()) == minLen) return C;
        else return C += A.length() == minLen ? B.substring(minLen) : A.substring(minLen);
    }

    public int zipcode(int A, int B) {
        String a = Integer.toString(A);
        String b = Integer.toString(B);

        return 0;
    }
}
