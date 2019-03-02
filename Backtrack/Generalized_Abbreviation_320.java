package Leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Generalized_Abbreviation_320 {

    /**
     * LeetCode solution, smart
     * @param word
     * @return
     */
    public List<String> generateAbbreviations_lc(String word) {
        List<String> res = new ArrayList<>();
        generate_lc(res, word, "", 0, 0);
        return res;
    }

    private void generate_lc(List<String> res, String word, String pre, int i, int number) {
        if (i == word.length()) {
            res.add(number > 0 ? pre + number : pre);
            return;
        }

        // case1: character at word position i abbreviate to number
        generate_lc(res, word, pre, i+1, number+1);
        // case2: character at word position i do not abbreviate to number
        generate_lc(res, word, pre+(number>0 ? number : "")+word.charAt(i), i+1, 0);
    }

    /**
     * My solution, very slow
     * @param word
     * @return
     */
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word.equals("")) {
            res.add("");
            return res;
        }

        generate(res, "", word);
        return res;
    }

    private void generate(List<String> res, String pre, String curr) {
        for (int start = 0; start < curr.length(); start++) {
            for (int end = start; end < curr.length(); end++) {
                if (!res.contains(pre + curr)) res.add(pre + curr);

                String before = curr.substring(0, start);
                String number = Integer.toString(end-start+1);
                String after = curr.substring(end+1);

                if (after.length() <= 1) {
                    res.add(pre + before + number + after);
                } else {
                    generate(res, pre + before + number + after.substring(0,1), after.substring(1));
                }
            }
        }
    }
}
