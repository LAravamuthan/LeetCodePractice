package asu.edu.marisol;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RobotRoomCleaner {

    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();

        public void turnRight();

        // Clean the current cell.
        public void clean();
    }

    /**
     * Backtracking algorithm, lets see how it goes.
     * TODO: Read the explanation and also find the reason why we need to turn only on right, not left.
     *     IMO going left also works.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (N).
     */
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        this.visited = new HashSet<>();
        backTrack(0, 0, 0);
    }

    private Robot robot;
    private Set<Pair<Integer, Integer>> visited;

    // keep going right i.e -> up, right, down and left.
    private int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    private void backTrack(int row, int col, int direction) {
        robot.clean();
        visited.add(new Pair<>(row, col));

        for (int i = 0; i < 4; i++) {
            int newDirection = (direction + i) % 4;
            int newRow = directions[newDirection][0] + row;
            int newCol = directions[newDirection][1] + col;

            if (!visited.contains(new Pair<>(newRow, newCol)) && robot.move()) {
                backTrack(newRow, newCol, newDirection);
                goBack();
            }

            robot.turnRight();
        }
    }

}
