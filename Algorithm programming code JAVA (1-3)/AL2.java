import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge> {
    int v;
    int w;

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    
    @Override
    public int compareTo(Edge e) {
        return this.v - e.v;
    }
}

public class AL2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int rep = 0; rep < t; rep++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Edge>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<Edge>();
            }
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                graph[u].add(new Edge(v, w));
            }
            for (int i = 0; i < n; i++) {
                Collections.sort(graph[i]);
                for (Edge e: graph[i]) {
                    System.out.print(e.v);
                    System.out.print(" ");
                }
                System.out.println();
                for (Edge e: graph[i]) {
                    System.out.print(e.w);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}