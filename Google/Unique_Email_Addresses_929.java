package Leetcode.Google;

import java.util.HashSet;
import java.util.Set;

public class Unique_Email_Addresses_929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] local_domain = email.split("@"); // local = local_domain[0], domain = local_domain[1]
            String[] locals = local_domain[0].split("\\+"); // take locals[0]
            String local = locals[0].replace(".","");
            set.add(local + "@" + local_domain[1]);
        }
        return set.size();
    }
}