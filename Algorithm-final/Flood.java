import java.util.Scanner;

public class Flood {
 
    public static int floodDFS(int[][] grid, int x, int y, int n, int m) {
        if(grid[x][y] == 1) return 0;
        grid[x][y] = 1;
        int cnt = 1;
        if(x > 0) cnt += floodDFS(grid, x-1, y, n, m);
        if(x < n-1) cnt += floodDFS(grid, x+1, y, n, m);
        if(y > 0) cnt += floodDFS(grid, x, y-1, n, m);
        if(y < n-1) cnt += floodDFS(grid, x, y+1, n, m);
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int rep=0; rep<t; rep++) {
            
        }
    }
}
