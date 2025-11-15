

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, P;
    static int[] S;
    static byte[][] game;
    static Queue<Castle>[] players;
    static boolean[][] visited;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Castle {
        int r, c;

        public Castle(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        /*
            1. 각 플레이어의 성을 좌표 값 리스트를 만들어 관리
                - 그렇지 않은 경우 브루트포스로 계산 값 증가 (Time Memory TradeOff)
                - 아니면 큐로 관리해도 괜찮을 듯, 이전 성은 사용 X
            2. 각 성(List or Queue)에서 BFS 탐색 진행
                - Temp Queue를 통해서 스텝 별 Castle 구분

         */

        init();

        while (true) {
            boolean isFin = true;

            for (int i = 1; i <= P; i++) {
                if (play(i)) {
                    isFin = false;
                }
            }

            if (isFin) break;
        }

        printResult();

    }

    static void printResult() {
        StringBuilder sb = new StringBuilder();
        int[] playerResult = new int[P + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (game[i][j] == -1) continue;

                playerResult[game[i][j]]++;
            }
        }

        for (int i = 1; i <= P; i++) {
            sb.append(playerResult[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

    static boolean play(int player) {
        Queue<Castle> tmp = new LinkedList<>();
        Queue<Castle> q = players[player];
        int s = S[player];

        if (q.isEmpty()) return false;
        for (int dist = 0; dist < s; dist++) {
            while (!q.isEmpty()) {
                Castle c = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = c.r + dr[i];
                    int nc = c.c + dc[i];


                    if (nr < 0 || nr >= N || nc < 0 | nc >= M) continue;
                    if (visited[nr][nc] || game[nr][nc] != 0) continue;

                    tmp.add(new Castle(nr, nc));
                    game[nr][nc] = (byte) (player);
                    visited[nr][nc] = true;

                }

            }

            if (tmp.isEmpty()) break;

            while (!tmp.isEmpty()) {
                q.offer(tmp.poll());
            }
        }
        return true;
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        P = Integer.parseInt(input[2]);

        S = new int[P + 1];
        players = new LinkedList[P + 1];
        game = new byte[N][M];
        visited = new boolean[N][M];

        for (int i = 1; i <= P; i++) {
            players[i] = new LinkedList<>();
        }

        input = br.readLine().split(" ");
        for (int i = 1; i <= P; i++) {
            S[i] = Integer.parseInt(input[i - 1]);
            if (S[i] > 1000) {
                S[i] = 1000;
            }
        }

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                if (row.charAt(j) == '.') {
                    game[i][j] = 0;
                    continue;
                }

                if (row.charAt(j) == '#') {
                    game[i][j] = -1;
                    continue;
                }

                int v = row.charAt(j) - '0';
                game[i][j] = (byte) v;
                players[v].add(new Castle(i, j));
                visited[i][j] = true;
            }
        }

    }
}
