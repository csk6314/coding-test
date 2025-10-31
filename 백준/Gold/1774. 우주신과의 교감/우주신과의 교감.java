

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main{
    static int N,M;
    static int[][] vertex;
    static ArrayList<Edge> edges;
    static int[] parent, rank;
    static int connected = 0;

    static class Edge {
        int a,b;
        double w;

        public Edge(int a,int b, double w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        System.out.printf("%.2f",getMinLen());
    }

    static public int find(int v) {
        if(parent[v] == v) {
            return v;
        }
        return parent[v] = find(parent[v]);
    }

    static public boolean union(int a,int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return false;

        if(rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
            return true;
        }

        if(rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
            return true;
        }

        parent[rootB] = rootA;
        rank[rootA]++;
        return true;
    }

    static public double getMinLen() {
        double ans = 0;

        for(int i = 0;i<edges.size();i++) {
            Edge e = edges.get(i);

            if(union(e.a,e.b)) {
                ans += e.w;
                connected++;
            }

            if(connected == N-1) break;
        }

        return ans;
    }



    static public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        vertex = new int[N+1][2];
        edges = new ArrayList<>();

        // 정점 초기화
        for(int i = 1;i<=N;i++) {
            input = br.readLine().split(" ");
            vertex[i] = new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])};
        }

        rank = new int[N+1];
        parent = new int[N+1];
        for(int i = 1;i<=N;i++) {
            parent[i] = i;
        }

        // 간선
        for(int i = 1;i<=N;i++) {
            for(int j = i+1;j<=N;j++) {
                int xDiff = Math.abs(vertex[i][0] - vertex[j][0]);
                int yDiff = Math.abs(vertex[i][1] - vertex[j][1]);
                double d = Math.sqrt(Math.pow(xDiff,2) + Math.pow(yDiff,2));

                edges.add(new Edge(i,j,d));
            }
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Double.compare(o1.w,o2.w);
            }
        });

        for(int i = 0;i<M;i++) {
            input = br.readLine().split(" ");
            int a =Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            if(union(a,b)) {
                connected++;
            }

        }

    }
}
