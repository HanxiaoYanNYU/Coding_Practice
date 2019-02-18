package Leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution I figured out myself, beats 58% solutions
 */
public class Generate_Parentheses_22 {

    private int a = 0; // the number of opening parenthesis need to be closed
    private int c = 0; // the number of closing parenthesis we can use

    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();

        a = 1; // since each parenthesis combination has to be start from "("
        c = n;
        String p = "(";
        List<String> res = new ArrayList<>();
        findCombination(p, res);
        return res;
    }

    private void findCombination(String p, List<String> res) {
        // if the number of "(" needed to be closed equals to the number of ")" we just
        // add all remaining ")" to the current string's end, and this is one of our valid combination
        if (a == c) {
            String s = "";
            for (int i = 0; i < c; i++) {
                s += ")";
            }
            res.add(p + s);
        }
        else {
            // if we have zero "(" that needed to be closed, then the next choice has to be "(", since
            // the current parentheses are all paired to each other.
            if (a == 0) {
                a++; findCombination(p + "(", res); a--;
            } else {
                // else we can feel free to either choose "(" or ")" as our next parenthese
                // case1: chose "("
                a++; findCombination(p + "(", res); a--;
                // case2: chose ")"
                a--; c--; findCombination(p + ")", res); a++; c++;
            }
        }
    }
}
