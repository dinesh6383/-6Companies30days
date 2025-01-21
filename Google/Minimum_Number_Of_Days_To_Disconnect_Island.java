package Google;


public class Minimum_Number_Of_Days_To_Disconnect_Island {
    public static  int[][] visited;
    public static int minDays(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        visited = new int[n][m];

        int island = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    dfs(i, j, grid);
                    island++;
                }
            }
        }

        if(island != 1) return 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;

                    visited = new int[n][m];
                    int count = 0;
                    for(int row = 0; row < n; row++) {
                        for(int col = 0; col < m; col++) {
                            if(grid[row][col] == 1 && visited[row][col] == 0) {
                                dfs(row, col, grid);
                                count++;
                            }
                        }
                    }

                    if(count != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    public static void dfs(int row, int col, int[][] grid) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0 || visited[row][col] == 1) return;
        
        visited[row][col] = 1;
        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for(int[] dir : direction) {
            int nx = dir[0] + row;
            int ny = dir[1] + col;
            dfs(nx, ny, grid);
        }
    }
    public static void main(String[] args) {
        int[][] grid = {{1,1}};
        int result = minDays(grid);
        System.out.println(result);
    }
}
