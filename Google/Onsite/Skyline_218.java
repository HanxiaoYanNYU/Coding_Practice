package Leetcode.Google.Onsite;

import java.util.*;

public class Skyline_218 {

    public static void main(String[] args) {
        int[][] buildings = {{0,2,3}, {2,5,3}};
        List<int[]> res = new Skyline_218().getSkyline(buildings);
        for (int[] r : res) System.out.println(r[0] + ", " + r[1]);
    }

    /**
     * Use list to store all events, and sort this list according to x, type, height
     *
     * Use treemap to store heights （这些高度是所有可以遮挡住后边新进入的方块左edge或右edge的方块们的高度）,
     * key = height, value = DUMMY (dont care about the value, just want to have a data structure can operate
     * add(), remove(), findMax() in O(logn) time)
     *
     * @param buildings
     * @return
     */
    public List<int[]> getSkyline(int[][] buildings) {

        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) return res;

        List<Event> events = new ArrayList<>();
        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];
            events.add(new Event(left, height, 0));
            events.add(new Event(right, height, 1));
        }
        Collections.sort(events, new Comparator<Event>(){
            @Override
            public int compare(Event e1, Event e2) {
                if (e1.x != e2.x) return e1.x - e2.x;
                else {
                    if (e1.type != e2.type) return e1.type - e2.type;
                    else {
                        if (e1.type == 0) return e2.height - e1.height;
                        else return e1.height - e2.height;
                    }
                }
            }
        });

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        for (Event e : events) {
            if (e.type == 0) {
                if (map.lastKey() < e.height) res.add(new int[]{e.x, e.height});
                map.put(e.height, map.getOrDefault(e.height, 0) + 1);
            } else {
                map.put(e.height, map.get(e.height) - 1);
                if (map.get(e.height) == 0) map.remove(e.height);
                if (map.lastKey() < e.height) res.add(new int[]{e.x, map.lastKey()});
            }
        }
        return res;
    }

    public class Event {
        public int x;
        public int height;
        public int type; // 0: entering. 1: leaving

        public Event(int x, int height, int type) {
            this.x = x;
            this.height = height;
            this.type = type;
        }
    }
}
