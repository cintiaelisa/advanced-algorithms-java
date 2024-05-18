package org.example.mazeEscape;

public class MazeSolver {

    private int[][] maze;
    private boolean[][] visited;
    private int startRow;
    private int startCol;

    public MazeSolver(int[][] maze, int startRow, int startCol) {
        this.maze = maze;
        this.visited = new boolean[maze.length][maze.length];
        this.startRow = startRow;
        this.startCol = startCol;
    }

    public void findWay() {
        if (dfs(startRow, startCol)) {
            System.out.println("We find the way!");
        } else {
            System.out.println("There is no way out. =(");
        }
    }

    private boolean dfs(int x, int y) {
        // base case
        if (x == maze.length - 1 && y == maze.length - 1) return true;

        if (isFeasible(x, y)) {
            visited[x][y] = true;

            // then we have to visit the next cell
            // going down
            if (dfs(x + 1, y)) return true;

            // going up
            if (dfs(x - 1, y)) return true;

            // going to the right
            if (dfs(x, y + 1)) return true;

            // going to the left
            if (dfs(x, y - 1)) return true;

            // Backtrack
            visited[x][y] = false;
            return false;
        }
        return false;
    }

    private boolean isFeasible(int x, int y) {
        // Check the vertical dimension
        if (x < 0 || x > maze.length - 1) return false;

        // Check the horizontal dimension
        if (y < 0 || y > maze.length - 1) return false;

        // Check if it was already visited
        if (visited[x][y]) return false;

        // There is an obstacle in the way
        if (maze[x][y] == 1) return false;

        return true;
    }

}
