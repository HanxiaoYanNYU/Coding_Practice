package Leetcode.Google.Onsite;

import java.util.*;

class SnakeGame {

    private int width;
    private int height;
    private int[][] food;
    private int score = 0;
    private int foodIndex = 0;
    private LinkedList<String> snakeList = new LinkedList<>(); // if snake moves, add new cell to first and
                                                               // remove last from LinkedList
    private Set<String> snakeSet = new HashSet<>(); // easy to check if snake bite itself

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        snakeList.add(0 + "," + 0); // snake head at 0,0
        snakeSet.add(0 + "," + 0);  // snake has body at 0,0 cell
    }

    public int move(String direction) {
        String[] snakeHead = snakeList.get(0).split(",");
        int headX = Integer.parseInt(snakeHead[0]);
        int headY = Integer.parseInt(snakeHead[1]);

        int[] d = new int[2];
        switch (direction) {
            case "U":
                d = new int[]{0, -1};
                break;
            case "D":
                d = new int[]{0, 1};
                break;
            case "L":
                d = new int[]{-1, 0};
                break;
            case "R":
                d = new int[]{1, 0};
                break;
        }

        // case1: next cell cross screen boundary
        int newX = headX + d[0];
        int newY = headY + d[1];
        if (newX < 0 || newX > width-1 || newY < 0 || newY > height-1) return -1;

        String newPos = newX + "," + newY;
        // case2: snake bite itself
        // Note: snake can only bite on its body except its tail, since tail and head has same speed.
        if (snakeSet.contains(newPos) && !newPos.equals(snakeList.getLast())) return -1;
        // case3: screen has food and snake can bite food
        if (foodIndex < food.length && food[foodIndex][1] == newX && food[foodIndex][0] == newY) {
            score++; foodIndex++; // next fruit is ready on screen
            snakeList.addFirst(newPos); // increase snake body on its head
            snakeSet.add(newPos);
            return score;
        }
        // case4: nothing happened except moved one step forward in direction
        // Before we add new head into snakeList and snakeSet, we should remove the tail from list and set first.
        // Otherwise we may lose the head position in snakeSet.
        // This case happens when the head's new position is its tail, since snakeSet already
        // contains head's new position, if we add head first (since set do not allow duplicate value,
        // it still remain one position) then remove tail from snakeSet, we accidentally remove
        // the head position too.
        else {
            snakeSet.remove(snakeList.getLast());
            snakeList.removeLast(); // remove tail from snakebody
            snakeList.addFirst(newPos); // move snake head to new position
            snakeSet.add(newPos);
            return score;
        }
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame(3, 3, new int[][]{{2,0},{0,0},{0,2},{2,2}});
        game.move("D");
        game.move("D");
        game.move("R");
        game.move("U");
        game.move("U");
        game.move("L");
        game.move("D");
        game.move("R");
        game.move("R");
        game.move("U");
        game.move("L");
        game.move("D");
    }
}
