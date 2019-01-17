package Leetcode;

import Leetcode.BFS.Medium.*;
import Leetcode.Binary_Search.Easy.*;
import Leetcode.Binary_Search.Medium.*;
import Leetcode.DFS.Easy.Flood_Fill_733;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] res = Flood_Fill_733.floodFill(image,1,1,2);
    }

    public int getAge() {

        return 10;
    }

}
