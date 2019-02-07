package Leetcode.Google.Onsite;

import java.util.HashSet;
import java.util.Set;

public class Robot_Room_Cleaner_489 {

    public void cleanRoom(Robot robot) {
        Set<String> cleaned = new HashSet<>();
        clean(robot, 0, 0, 0, 1, cleaned);
    }

    /*
        first clean current cell
        second explore and clean all neighbor cells

        (deltaX, deltaY) 相当于一个单位矢量，它的方向指向robot前进的方向，同时也可以用它们来计算下一个cell的坐标
     */
    private void clean(Robot robot, int currX, int currY, int deltaX, int deltaY, Set<String> cleaned) {
        robot.clean();
        cleaned.add(currX + "," + currY); // use x,y represent each cell

        // After changing direction 4 times, robot face to the original direction
        for (int i = 0; i < 4; i++) {
            // calculate next cell position to explore
            int nextX = currX + deltaX;
            int nextY = currY + deltaY;

            // if next cell is not cleaned yet and robot can move to the next cell, then let robot move
            if (!cleaned.contains(nextX + "," + nextY) && robot.move()) {
                clean(robot, nextX, nextY, deltaX, deltaY, cleaned);

                // When finish clean (nextX, nextY) and all of its further cells, robot should move back
                // to (currX, currY) so as to change direction and clean other neighbor cells
                // Make sure the direction robot point to is same to direction before move
                robot.turnLeft(); robot.turnLeft(); // 掉头
                robot.move(); // 开车
                robot.turnLeft(); robot.turnLeft(); // 再掉头
            }

            // Change robot direction (we choose to turn left every time)
            robot.turnLeft();

            // Also update the unit vector which now point to next direction
            // 使用直角坐标系，我们可以知道，左转后的单位向量为: (-y, x)
            int tempDirX = deltaX;
            deltaX = -deltaY;
            deltaY = tempDirX;
        }
    }

    interface Robot {
        boolean move();
        void turnLeft();
        void turnRight();
        void clean();
    }
}
