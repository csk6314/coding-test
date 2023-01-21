package programmers.level2_2;

import java.util.LinkedList;
import java.util.Queue;

public class shortestPathInGame {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }
    static class Point{
        int x,y;
        int turn;
        public Point(int x,int y,int turn) {
            this.x =x;
            this.y =y;
            this.turn = turn;
        }
    }
    public static int solution(int[][] maps) {
        int answer = -1;
        Queue<Point> q = new LinkedList<>();
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int n = maps.length;
        int m = maps[0].length;
        q.add(new Point(0,0,1));
        maps[0][0] = 0;
        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y= p.y;
            int t = p.turn;
            if(x+1==m && y+1==n) {
                answer = t;
                break;
            }
            //System.out.println("x :" + n + ", y : " + m + ", t : " + t);

            for(int i =0;i<4;i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx < m && nx >= 0 && ny < n && ny >= 0) {
                    if(maps[ny][nx] == 1) {
                        q.offer(new Point(nx,ny,t+1));
                        maps[ny][nx] = 0;
                    }
                }
            }

        }
        return answer;
    }
}
