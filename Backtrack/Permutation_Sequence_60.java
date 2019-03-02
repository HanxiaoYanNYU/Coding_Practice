package Leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutation_Sequence_60 {

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        String res = "";
        k--;
        while (list.size() > 1) {
            int product = calculate(--n); // n!
            int quotient = k / product;

            res += Integer.toString(list.get(quotient));
            list.remove(quotient);
            k -= product * quotient;
        }

        res += Integer.toString(list.get(0));
        return res;
    }

    private int calculate(int n) {
        if (n == 0) return 1;
        int product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        return product;
    }

    public static void main(String[] args) {
        Permutation_Sequence_60 m = new Permutation_Sequence_60();
        String res = m.getPermutation(3,2);
        System.out.println(res);
    }
}
