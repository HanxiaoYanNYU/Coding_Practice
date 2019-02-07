package Leetcode.Google.Onsite;

import java.util.Random;
import java.util.TreeMap;

public class Random_Point_Non_overlapping_Rectangles_497 {

    private TreeMap<Integer, Integer> map = new TreeMap<>();
    private Random random = new Random();
    private int totalArea;
    private int[][] rectsCopy;

    public Random_Point_Non_overlapping_Rectangles_497(int[][] rects) {
        rectsCopy = rects;
        int area = 0;
        for (int i = 0; i < rects.length; i++) {
            area += calculateArea(rects[i]); // calculate the area of this rectanguler
            map.put(area, i);
        }
        totalArea = area;
    }

    public int[] pick() {
        int rectIndex = map.get(map.ceilingKey(random.nextInt(totalArea) + 1)); // get the index of rect
        int[] rect = rectsCopy[rectIndex];
        int x1 = rect[0];
        int y1 = rect[1];
        int x2 = rect[2];
        int y2 = rect[3];
        return new int[]{x1 + random.nextInt(x2-x1+1), y1 + random.nextInt(y2-y1+1)};
    }

    private int calculateArea(int[] rect) {
        return (rect[2]-rect[0]+1) * (rect[3]-rect[1]+1);
    }
}
