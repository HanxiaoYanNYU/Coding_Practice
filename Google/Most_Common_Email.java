package Leetcode.Google;

import java.util.HashMap;
import java.util.Map;

public class Most_Common_Email {

    public static int solution(String[] L) {
        Map<String, Integer> emailMap = new HashMap<>();
        int mostCommon = -1;

        for (String email : L) {
            String[] local_domain = email.split("@");
            String local = local_domain[0].split("\\+")[0].replace(".", "");
            String domain = local_domain[1];
            String cleanEmail = local + "@" + domain;

            emailMap.put(cleanEmail, emailMap.getOrDefault(cleanEmail, 0) + 1);

            mostCommon = emailMap.get(cleanEmail) > mostCommon ? emailMap.get(cleanEmail) : mostCommon;
        }

        return mostCommon == -1 ? 0 : mostCommon;
    }
}
