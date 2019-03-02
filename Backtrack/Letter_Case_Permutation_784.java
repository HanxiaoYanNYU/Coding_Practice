package Leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Letter_Case_Permutation_784 {

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if (S == null) return res;
        if (S == "") {
            res.add("");
            return res;
        }

        permutate(S.toLowerCase(), 0, res);
        return res;
    }

    private void permutate(String s, int i, List<String> res) {
        if (i == s.length()) {
            res.add(s);
            return;
        }

        char[] c = s.toCharArray();
        if (c[i] >= '0' && c[i] <= '9') permutate(s, i+1, res);
        else {
            permutate(new String(c), i+1, res);
            c[i] = Character.toUpperCase(c[i]);
            permutate(new String(c), i+1, res);
        }
    }
}
