package Leetcode.Google.Onsite;

import java.util.*;

public class Isomorphic_Strings_205 {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> visited = new HashSet<>();

        int i;
        for (i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (map.containsKey(sc) && map.get(sc) != tc) break;
            if (!map.containsKey(sc)) {
                if (visited.contains(tc)) break;
                map.put(sc, tc);
                visited.add(tc);
            }
        }

        return i == s.length();
    }
}
