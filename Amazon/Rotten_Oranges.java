package Amazon;
import java.util.*;

public class Rotten_Oranges {
    // Time complexity : O(n * m) | Space complexity : O(n * m)
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited = new boolean[n][m];
        boolean hasNonRottenOrange = false;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                }

                if(grid[i][j] == 1) hasNonRottenOrange = true;
            }
        }

        if(queue.isEmpty() && hasNonRottenOrange) return -1;
        if(queue.isEmpty() && !hasNonRottenOrange) return 0;

        int minRottenTime = 0;

        while(!queue.isEmpty()) {
            int[] rottenOrange = queue.poll();
            minRottenTime = Math.max(minRottenTime, rottenOrange[2]);

            for(int[] side : direction) {
                int nx = rottenOrange[0] + side[0];
                int ny = rottenOrange[1] + side[1];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1 && !visited[nx][ny]) {
                    int[] newRottenOrange = {nx, ny, rottenOrange[2] + 1};
                    visited[nx][ny] = true;
                    grid[nx][ny] = 2;
                    queue.add(newRottenOrange);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }

        return minRottenTime;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,2}};
        int minimumTime = orangesRotting(grid);
        System.out.println(minimumTime);
    }
}
