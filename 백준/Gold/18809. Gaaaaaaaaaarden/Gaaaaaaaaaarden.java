

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, G, R;
    static int result = 0;
    static int[][] garden;
    static int[][][] temp;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static class Fluid {
        int r,c;

        public Fluid(int r,int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        dfs(0,0,0);
        System.out.println(result);


    }

    static public void simulate() {
        temp = new int[N][M][2];
        for(int i = 0;i<N;i++) {
            for(int j=0;j<M;j++) {
                temp[i][j] = new int[]{garden[i][j], 0};
            }
        }

        Queue<Fluid> q = new LinkedList<>();

        for(int i = 0;i<N;i++) {
            for(int j = 0;j<M;j++) {
                if(temp[i][j][0] == 3 || temp[i][j][0] == 4) {
                    q.offer(new Fluid(i,j));
                }
            }
        }

        while(!q.isEmpty()) {
            Fluid f = q.poll();
            int[] v = temp[f.r][f.c];
          //  System.out.println(f.r + " , " + f.c);

            if(v[0] == 5) continue;

            for(int i = 0;i<4;i++) {
                int nr = dr[i] + f.r;
                int nc = dc[i] + f.c;

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(temp[nr][nc][0] == 0) continue;

                if(v[0] == 3 && temp[nr][nc][0] == 4 && temp[nr][nc][1] == v[1]+1) {
                    temp[nr][nc][0] = 5;
                    continue;
                }

                if(v[0] == 4 && temp[nr][nc][0] == 3 && temp[nr][nc][1] == v[1]+1) {
                    temp[nr][nc][0] = 5;
                    continue;
                }

                if(temp[nr][nc][0] == 1 || temp[nr][nc][0] == 2) {
                    q.offer(new Fluid(nr, nc));
                    temp[nr][nc][0] = v[0];
                    temp[nr][nc][1] = v[1] + 1;
                }
            }
        }

        int flowers = 0;

        for(int i = 0;i<N;i++) {
            for(int j = 0;j<M;j++) {
                if(temp[i][j][0] == 5) {
                    flowers++;
                }
            }
        }

//        System.out.println("---------------------------------------");
//        for(int i = 0;i<N;i++) {
//            for(int j = 0;j<M;j++) {
//                System.out.printf("%5d",temp[i][j][0]);
//            }
//            System.out.println();
//        }

        result = Math.max(result, flowers);
    }

    static public void dfs(int r, int g, int start) {
        if (r == R && g == G) {
            // 시뮬레이션 코드 실행
            simulate();
            return;

        }

        for(int i = start; i<N*M;i++) {
            int row = i / M;
            int col = i % M;

            if (garden[row][col] != 2) continue;

            if (r < R) {
                garden[row][col] = 3;
                dfs(r + 1, g, i +1);
                garden[row][col] = 2;
            }

            if (g < G) {
                garden[row][col] = 4;
                dfs(r, g + 1, i + 1);
                garden[row][col] = 2;
            }
        }

    }

    static public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        G = Integer.parseInt(input[2]);
        R = Integer.parseInt(input[3]);

        garden = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                garden[i][j] = Integer.parseInt(input[j]);
            }
        }
    }
}
