package Leetcode.Twitter;

import java.util.ArrayList;
import java.util.List;

public class OA1 {

    public static void main(String[] args) {

    }

    public List<Integer> minimalOperations(List<String> words) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        if (words == null || words.size() == 0) return res;
        for (String word : words) {
            int count = change(word);
            res.add(count);
        }
        return res;
    }

    private int change(String word) {
        if (word == null || word.length() <= 1) return 0;
        int count = 0;
        int left = 0;
        int right = 0;
        for (right = 1; right < word.length(); right++) {
            if (word.charAt(left) != word.charAt(right)) {
                int len = right - left;
                count += len / 2;
                left = right;
            }
        }
        count += (right - left) / 2;
        return count;
    }
}
