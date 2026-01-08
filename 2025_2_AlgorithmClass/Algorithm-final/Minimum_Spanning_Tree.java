import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Edge {
    int v;
    int w;
    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

class Wedge implements Comparable<Wedge> {
    int u, v, w;
    
    public Wedge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Wedge e) {
        return this.w - e.w;
    }
}

public class Minimum_Spanning_Tree {
    public static int find(int u, int[] parent) {
        if (u == parent[u]) return u;
        parent[u] = find(parent[u], parent);
        return find(parent[u], parent);
    }
    public static void union(int u, int v, int[] parent, int[] rank) {
        u = find(u, parent);
        v = find(v, parent);
        if(rank[u] > rank[v]) parent[v] = u;
        else if(rank[u] < rank[v]) parent[u] = v;
        else {
            parent[u] = v;
            rank[v] += 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int rep=0; rep<t; rep++) {
            int n, m;
            n = sc.nextInt();
            m = sc.nextInt();
            Wedge[] edges = new Wedge[m];
            ArrayList<Edge>[] graph = new ArrayList[n];
            for (int i=0; i<n; i++) {
                graph[i] = new ArrayList<Edge>();
            }
            for(int i=0; i<m; i++) {
                int u, v, w;
                u = sc.nextInt();
                v = sc.nextInt();
                w = sc.nextInt();
                graph[u].add(new Edge(v, w));
                graph[v].add(new Edge(u, w));
                edges[i] = new Wedge(u, v, w);
            }
            Arrays.sort(edges);
            int weight = 0;
            int[] parent = new int[n];
            for(int i=0; i<n; i++) parent[i] = i;
            int[] rank = new int[n];
            for(int i=0; i<m; i++) {
                int u = edges[i].u;
                int v = edges[i].v;
                int w = edges[i].w;
                if (find(u, parent) != find(v, parent)) {
                    weight += w;
                    union(u, v, parent, rank);
                }
            }
            System.out.println(weight);
        }
    }
}
