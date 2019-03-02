package Leetcode.Google.OA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Unique_Email_Addresses_929 {

    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) return 0;
        if (emails.length == 1) return 1;

        Map<String, Integer> map = new HashMap<>();
        for (String email : emails) {
            String[] local_domain = email.split("@"); // local = local_domain[0], domain = local_domain[1]
            String[] locals = local_domain[0].split("\\+"); // take locals[0]
            String key = locals[0].replace(".","");
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int mostCommon = -1;
        for (Integer count : map.values()) {
            mostCommon = Math.max(mostCommon, count);
        }
        return mostCommon;
    }

    public static void main(String[] args) {
        String s = "ab";
        String b = s.substring(0,1);
        System.out.println(b);
    }
}