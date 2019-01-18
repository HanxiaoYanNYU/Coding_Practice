package Leetcode.DFS.Medium;

import java.util.Stack;

public class Decode_String_394 {

    /**
     * My AC solution, but beats only 0.88%
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        if (s == null || s.length() == 0) return s;

        char[] c = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        String res = "";

        for (int i = 0; i < c.length; i++) {
            if (c[i] == ']') {
                String repeat = "";
                while (stack.peek() != '[' && stack.peek() >= 'a' && stack.peek() <= 'z' || stack.peek() >= 'A' && stack.peek() <= 'Z') {
                    repeat = stack.pop() + repeat;
                }
                stack.pop(); // pop '['
                String num = "";
                while (!stack.empty() && stack.peek() >= '0' && stack.peek() <= '9') {
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
}
