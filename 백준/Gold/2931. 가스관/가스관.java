
import java.io.*;
import java.util.*;

public class Main{
    // 파이프라인 방향 (상, 하, 좌, 우), true = 파이프라인 열려있는 방향
    static final boolean[][] pipeDir = {
            {true, true, false, false},
            {false, false, true, true},
            {true, true, true, true},
            {false, true, false, true},
            {true, false, false, true},
            {true, false, true, false},
            {false, true, true, false}
    };
    static final char[] pipeClass = {'|', '-', '+', '1', '2', '3', '4'};
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    static int R,C;
    static char[][] map;

    public static void main(String[] args) throws IOException{
        init();

        int[] blankPos = {-1, -1};

        for(int i = 1;i<R+1;i++) {
            for(int j =1;j<C+1;j++) {
                if(map[i][j] == 'M') {
                    int[] tmp = getBlankPos(i,j);
                    blankPos[0] = tmp[0];
                    blankPos[1] = tmp[1];
                    break;
                }
            }

            if(blankPos[0] != -1) break;

        }


        int idx = fillBlankPos(blankPos[0],blankPos[1]);
        if(idx == -1) return;
        char pipe = pipeClass[idx];

        System.out.print(blankPos[0] + " " + blankPos[1] + " " + pipe);

    }

    static public int fillBlankPos(int r, int c) {
        boolean[] connected = new boolean[4];

        for(int i = 0;i<4;i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];

            if(!isValidPos(nr, nc)) continue;
            if(map[nr][nc] == '.' || map[nr][nc] == 'Z' || map[nr][nc] == 'M') continue;

            int pipeNum = getPipeNum(map[nr][nc]);
            if(isConnected(i, pipeNum)) {
                connected[i] = true;
            }
        }

        for(int i = 0;i<pipeDir.length;i++) {
            boolean FLAG = true;
            for(int j = 0;j<4;j++) {
                if(pipeDir[i][j] != connected[j]) {
                    FLAG = false;
                    break;
                }
            }

            if(FLAG) {
                return i;
            }
        }

        return -1;
    }

    static public int[] getBlankPos(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[R+1][C+1];

        visited[r][c] = true;

        //시작 점과 연결된 파이프라인 탐색
        for(int i = 0;i<4;i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];

            if(!isValidPos(nr,nc)) continue;
            if(map[nr][nc] == '.' || map[nr][nc] == 'Z') continue;

            int pnum = getPipeNum(map[nr][nc]);

            if(isConnected(i, pnum)) {
                q.offer(new int[]{nr,nc});
                visited[nr][nc] = true;
            }
        }

        // 이후 파이프라인 탐색
        int[] blankPos = new int[2];
        while(!q.isEmpty()) {
            int[] pos = q.poll();

            for(int i = 0;i<4;i++) {
                int nr = pos[0] + dr[i];
                int nc = pos[1] + dc[i];

                if(!isValidPos(nr,nc) ||  visited[nr][nc]) continue;
                if(map[nr][nc] == 'Z') continue;

                int curPipeNum = getPipeNum(map[pos[0]][pos[1]]);
                if(map[nr][nc] == '.') {
                    if(pipeDir[curPipeNum][i]) {
                        blankPos[0] = nr;
                        blankPos[1] = nc;
                        return blankPos;
                    }

                    continue;
                }

                int pipeNum = getPipeNum(map[nr][nc]);
                if(isConnected(i,pipeNum)) {
                    q.offer(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }

        }
        return new int[]{-1,-1};
    }

    static public boolean isConnected(int entryDir, int pipeNum) {
        int exitDir = (entryDir >= 2) ? ((entryDir-2)^1) + 2 : entryDir^1;
        return pipeDir[pipeNum][exitDir];
    }

    static public boolean isValidPos(int nr, int nc) {
        return nr >= 1 && nr <= R && nc >= 1 && nc <= C;
    }

    static public int getPipeNum(char ch) {
        switch (ch) {
            case '|': return 0;
            case '-': return 1;
            case '+': return 2;
            case '1': return 3;
            case '2': return 4;
            case '3': return 5;
            case '4': return 6;
            default: return -1;
        }
    }


    static public void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input =br.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new char[R+1][C+1];

        for(int i = 1;i<R+1;i++) {
            String line = br.readLine();
            for(int j=0;j<C;j++) {
                map[i][j+1] = line.charAt(j);
            }
        }
    }
}
