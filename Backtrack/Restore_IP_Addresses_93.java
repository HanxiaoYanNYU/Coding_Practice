package Leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Addresses_93 {

    /**
     * My solution, beat 91%
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return res;

        List<List<Integer>> dots = new ArrayList<>();
        findDots(dots, new ArrayList<>(), 1, s.length()-1);

        for (List<Integer> dot : dots) {
            String ip = getIp(s, dot);
            if (!ip.equals("")) res.add(ip);
        }
        return res;
    }

    private void findDots(List<List<Integer>> dots, List<Integer> track, int start, int limit) {
        if (track.size() == 3) {
            dots.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= limit; i++) {
            // backtracking 过程中记得要剪枝，不然会很慢
            if (track.size() == 0 && i>3 || track.size() != 0 && i-track.get(track.size()-1)>3) break;
            track.add(i);
            findDots(dots, track, i+1, limit);
            track.remove(track.size()-1);
        }
    }

    private String getIp(String s, List<Integer> dot) {
        int d1 = dot.get(0);
        int d2 = dot.get(1);
        int d3 = dot.get(2);

        if (d1>3 || d2-d1>3 || d3-d2>3 || s.length()-d3>3) return "";
        String s1 = s.substring(0,d1);
        String s2 = s.substring(d1,d2);
        String s3 = s.substring(d2,d3);
        String s4 = s.substring(d3);
        if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) return s1+"."+s2+"."+s3+"."+s4;
        return "";
    }

    private boolean isValid(String ip) {
        if (ip.length() > 1 && ip.charAt(0) == '0' || Integer.parseInt(ip) > 255) return false;
        return true;
    }
}
