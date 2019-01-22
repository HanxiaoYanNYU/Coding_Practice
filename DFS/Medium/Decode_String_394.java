package Leetcode.DFS.Medium;

import java.util.Stack;

public class Decode_String_394 {

    /**
     * My AC solution, but beats only 0.88%
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        char[] c = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        String res = "";

        for (int i = 0; i < c.length; i++) {
            if (c[i] == ']') {
                String repeat = "";
                while (stack.peek() != '[' && Character.isLetter(stack.peek())) {
                    repeat = stack.pop() + repeat;
                }
                stack.pop(); // pop '['
                String num = "";
                while (!stack.empty() && Character.isDigit(stack.peek())) {
                    num = stack.pop() + num;
                }
                String sum = "";
                for (int j = 0; j < Integer.parseInt(num); j++) {
                    sum += repeat;
                }
                for (char su : sum.toCharArray()) {
                    stack.push(su);
                }
            } else {
                stack.push(c[i]);
            }
        }

        for (char chars : stack) {
            res += chars;
        }
        return res;
    }

    /**
     * Leetcode Solution
     * @param s
     * @return
     */
    public static String decodeString_lc(String s) {
        if (s == null || s.length() == 0) return s;

        Stack<String> repeat = new Stack<>();
        Stack<String> letters = new Stack<>();

        letters.push("");
        int i = 0;
        char[] c = s.toCharArray();

        while (i < s.length()) {
            if (Character.isDigit(c[i])) {
                String num = "" + c[i];
                while (i + 1 < s.length() && Character.isDigit(c[i + 1])) {
                    i++;
                    num += c[i];
                }
                repeat.push(num);
                letters.push(""); // Each repeat number should be paired to a char sequence
            } else if (Character.isLetter(c[i])) {
                String preSequence = letters.pop();
                letters.push(preSequence + c[i]);
            } else if (c[i] == ']') {
                String concat = "";
                String repeatSequence = letters.pop();
                int repeatTimes = Integer.parseInt(repeat.pop());
                while (repeatTimes > 0) {
                    concat += repeatSequence;
                    repeatTimes--;
                }

                String preSequence = letters.pop();
                letters.push(preSequence + concat);
            }

            i++;
        }

        return letters.pop();
    }
}
