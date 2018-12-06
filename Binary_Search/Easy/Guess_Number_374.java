package Leetcode.Binary_Search.Easy;

public class Guess_Number_374 {
    public static int guessNumber(int n) {
        if (n == 1) return 1;

        int left = 1;
        int right = n;
        int middle;

        while (left <= right) {
            middle = left + (right - left) / 2;

            if (guess(middle) == 0) return middle;
            else if (guess(middle) < 0) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }

    private static int guess(int n) {
        return Integer.compare(n, 6);
    }
}
