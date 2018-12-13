package Leetcode.Google;

import java.util.HashSet;
import java.util.Set;

public class Past_Closest_Time {

    public static String pastClosestTime(String time) {
        char[] digits = time.replace(":", "").toCharArray();
        Set<String> times = new HashSet<>();

        findAllTimes(digits, "", times);
        if (times.size() == 0) return time;

        String res = findPastTime(new String(digits), times);
        return res.substring(0,2) + ":" + res.substring(2);
    }

    private static void findAllTimes(char[] digits, String currTime, Set<String> times) {
        if (currTime.length() == 4) {
            if (!currTime.equals(new String(digits)) && isValidTime(currTime)) {
                times.add(currTime);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            currTime += digits[i];
            findAllTimes(digits, currTime, times);
            currTime = currTime.substring(0, currTime.length() - 1);
        }
    }

    private static boolean isValidTime(String time) {
        char[] t = time.toCharArray();
        if (t[2] <= '5') {
            if (t[0] <= '2') {
                if (t[0] == '2') return t[1] <= '3';
                else return true;
            }
        }
        return false;
    }

    private static String findPastTime(String givenTime, Set<String> times) {
        int giventime = Integer.parseInt(givenTime);
        int diff = Integer.MIN_VALUE;
        String res = "";

        for (String t : times) {
            int time = Integer.parseInt(t);
            if (time < giventime) {
                if (time - giventime > diff) {
                    diff = time - giventime;
                    res = t;
                }
            } else {
                if (-(giventime + (2359-time+1)) > diff) {
                    diff = -(giventime + (2359-time+1));
                    res = t;
                }
            }
        }
        return res;
    }

}
