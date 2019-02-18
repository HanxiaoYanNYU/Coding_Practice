package Leetcode.Backtrack;

import java.util.*;

public class Letter_Combinations_Phone_Number_17 {

    /**
     * My solution, beats 100%
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        String[] phone = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; // ? - "0" is index
        backtrack("", digits, phone, 0, res);
        return res;
    }

    private void backtrack(String combination, String digits, String[] phone, int digitPos, List<String> res) {
        if (combination.length() == digits.length()) {
            res.add(combination);
            return;
        }

        for (int i = 0; i < phone[digits.charAt(digitPos)-'0'].length(); i++) {
            backtrack(combination + phone[digits.charAt(digitPos)-'0'].charAt(i), digits, phone,
                                digitPos+1, res);
        }
    }

    /**
     * My second solution, start from the last digit, 2ms beats 80%
     * @param digits
     * @return
     */
    public List<String> letterCombinations_1(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        String[] phone = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; // ? - "0" is index
        Queue<String> preCombines = new LinkedList<>();
        preCombines.add("");

        for (int i = digits.length()-1; i >= 0; i--) {
            int size = preCombines.size();
            while (size > 0) {
                String pre = preCombines.poll();
                for (Character c : phone[digits.charAt(i)-'0'].toCharArray()) {
                    preCombines.add(c + pre);
                }
                size--;
            }
        }

        res = new ArrayList<>(preCombines);
        return res;
    }

    public static void main(String[] args) {
        Letter_Combinations_Phone_Number_17 m = new Letter_Combinations_Phone_Number_17();
        List<String> res = m.letterCombinations_1("23");
        System.out.println(res);
    }
}
