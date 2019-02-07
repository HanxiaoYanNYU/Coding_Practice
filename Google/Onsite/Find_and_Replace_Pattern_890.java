package Leetcode.Google.Onsite;

import java.util.*;

public class Find_and_Replace_Pattern_890 {

    public List<String> findAndReplacePattern(String[] words, String p) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (word.length() != p.length()) continue;
            Map<Character, Character> map = new HashMap<>();
            Set<Character> set = new HashSet<>();
            int i;
            for (i = 0; i < p.length(); i++) {
                if (map.containsKey(p.charAt(i)) && map.get(p.charAt(i)) != word.charAt(i)) break;
                if (!map.containsKey(p.charAt(i))) {
                    if (set.contains(word.charAt(i))) break;
                    map.put(p.charAt(i), word.charAt(i));
                    set.add(word.charAt(i));
                }
            }
            if (i == p.length()) res.add(word);
        }
        return res;
    }
}
