import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class AL1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int rep = 0; rep < t; rep++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }
            for (int i = 0; i < n; i++) {
                Collections.sort(graph[i]);
                for (int v: graph[i]) {
                    System.out.print(v);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}