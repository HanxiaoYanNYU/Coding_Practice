package Leetcode.Google.Onsite;

import java.util.*;

public class Longest_Consecutive_Strings {

    public static void main(String[] args) {
        Longest_Consecutive_Strings m = new Longest_Consecutive_Strings();
        String[] phrases = {"hello hi", "hi lol", "lol blah", "lol oh", "oh shit", "shit happens"};
        for (String s: m.findLongest(phrases)) {
            System.out.println(s);
        }
    }

    public List<String> findLongest(String[] phrases) {
        // phrases[0]: "hello hi"
        // phrases[1]: "hi bob"
        if (phrases == null || phrases.length == 0) return null;

        Map<String, List<Integer>> firstWord = new HashMap<>();
        Map<String, List<Integer>> lastWord = new HashMap<>();
        Phrase[] p = new Phrase[phrases.length];
        Queue<Phrase> q = new LinkedList<>();

        for (int i = 0; i < phrases.length; i++) {
            String[] words = phrases[i].split(" ");
            String first = words[0];
            if (!firstWord.containsKey(first)) firstWord.put(first, new ArrayList<>());
            firstWord.get(first).add(i);
            Phrase phrase = new Phrase(first, "", 1, -1, i);
            p[i] = phrase;
        }

        for (int i = 0; i < phrases.length; i++) {
            String[] words = phrases[i].split(" ");
            String last = words[words.length - 1];
            if (!lastWord.containsKey(last)) lastWord.put(last, new ArrayList<>());
            lastWord.get(last).add(i);
            if (!firstWord.containsKey(last) ||
                    (firstWord.get(last).size() == 1 && firstWord.get(last).contains(i))) {
                p[i].last = last;
                q.add(p[i]);
            }
        }

        while (!q.isEmpty()) {
            Phrase currP = ((LinkedList<Phrase>) q).pop();
            for (Integer i : lastWord.getOrDefault(currP.first, new ArrayList<>())) {
                if (i == currP.index) continue;
                if (p[i].length - 1 < currP.length) {
                    p[i].length += currP.length - 1;
                    p[i].childIndex = currP.index;
                    q.add(p[i]);
                }
            }
        }

        int maxLen = -1;
        Phrase start = new Phrase(); // Dummy
        List<String> res = new ArrayList<>();
        for (Phrase ph : p) {
            if (maxLen < ph.length) {
                maxLen = ph.length;
                start = ph;
            }
        }

        while (start.childIndex != -1) {
            res.add(phrases[start.index]);
            start = p[start.childIndex];
        }
        res.add(phrases[start.index]);

        return res;
    }

    private class Phrase {
        public String first;
        public String last;
        public int length;
        public int childIndex;
        public int index;
        public Phrase() {}
        public Phrase(String first, String last, int length, int childIndex, int index) {
            this.first = first;
            this.last = last;
            this.length = length;
            this.childIndex = childIndex;
            this.index = index;
        }
    }
}
