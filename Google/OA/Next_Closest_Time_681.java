package Leetcode.Google.OA;

import java.util.*;

public class Next_Closest_Time_681 {

    /**
     * Accepted, But need to work on different solution
     *
     * @param time
     * @return
     */
    public static String nextClosestTime(String time) {
        char[] t = time.replace(":", "").toCharArray();
        char[] sorted = new char[4];
        for (int i = 0; i < 4; i++) {
            sorted[i] = t[i];
        }
        Arrays.sort(sorted);

        if (t[3] < '9') {
            int index = findNext(sorted, t[3], '9');
            if (index != -1) {
                t[3] = sorted[index];
                return result(t);
            }
        }
        if (t[2] < '5') {
            int index = findNext(sorted, t[2], '5');
            if (index != -1) {
                t[2] = sorted[index];
                t[3] = sorted[0];
                return result(t);
            }
        }

        if (t[0] == '2') {
            int index = findNext(sorted, t[1], '3');
            if (index != -1) {
                t[1] = sorted[index];
                t[2] = sorted[0];
                t[3] = sorted[0];
                return result(t);
            } else {
                for (int i = 0; i < sorted.length; i++) { t[i] = sorted[0]; }
                return result(t);
            }
        } else {
            int index = findNext(sorted, t[1], '9');
            if (index != -1) {
                t[1] = sorted[index];
                t[2] = sorted[0];
                t[3] = sorted[0];
                return result(t);
            } else {
                index = findNext(sorted, t[0], '2');
                if (index != -1) {
                    t[0] = sorted[index];
                    t[1] = t[2] = t[3] = sorted[0];
                    return result(t);
                } else {
                    for (int i = 0; i < sorted.length; i++) { t[i] = sorted[0]; }
                    return result(t);
                }
            }
        }
    }

    public static int findNext(char[] sorted, char target, char limit) {
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] > target && sorted[i] <= limit) return i;
        }
        return -1;
    }

    public static String result(char[] time) {
        char[] res = new char[5];
        res[0] = time[0];
        res[1] = time[1];
        res[2] = ':';
        res[3] = time[2];
        res[4] = time[3];
        return new String(res);
    }

    /**
     * DFS find all possible times and calculate diff between them to given time, find min diff and return
     *
     * @param time
     * @return
     */
    public static String nextTime(String time) {
        char[] digits = time.replace(":", "").toCharArray();
        Set<String> times = new HashSet<>();

        findAllTimes(digits, "", times);
        if (times.size() == 0) return time;

        String res = findNextTime(times, new String(digits));
        return res.substring(0,2) + ":" + res.substring(2);
    }

    private static void findAllTimes(char[] digits, String currTime, Set<String> times) {
        if (currTime.length() == 4) {
            if (!currTime.equals(new String(digits)) && isTimeValid(currTime)) {
                times.add(currTime);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            currTime += digits[i];
            findAllTimes(digits, currTime, times);
            currTime = currTime.substring(0, currTime.length()-1);
        }
    }

    private static boolean isTimeValid(String time) {
        char[] t = time.toCharArray();
        if (t[2] <= '5') {
            if (t[0] <= '2') {
                if (t[0] == '2') return t[1] <= '3';
                else return true;
            }
        }
        return false;
    }

    private static String findNextTime(Set<String> times, String givenTime) {
        int diff = Integer.MAX_VALUE;
        int giventime = Integer.parseInt(givenTime);
        String res = "";

        for (String t : times) {
            int time = Integer.parseInt(t);
            if (time < giventime) {
                if (diff > (time + (2359-giventime+1))) {
                    diff = (time + (2359-giventime+1));
                    res = t;
                }
            }
            else {
                if (diff > time - giventime) {
                    diff = time - giventime;
                    res = t;
                }
            }
        }
        return res;
    }
}
