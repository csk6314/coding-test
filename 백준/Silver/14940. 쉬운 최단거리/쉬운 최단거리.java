
import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		
		map = new int[N][M];
		
		int[] start = new int[2];
		
		for(int i = 0;i<N;i++) {
			inputs = br.readLine().split(" ");
			for(int j = 0;j<M;j++) {
				 map[i][j] = Integer.parseInt(inputs[j]);
				 if(map[i][j] == 2) {
					 start[0] = i;
					 start[1] = j;
				 }
			}
		}
		
		int[][] res = new int[N][M];
		
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				res[i][j] = -1;
				if(map[i][j] == 0) {
					res[i][j] = 0;
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		res[start[0]][start[1]] = 0;
		q.offer(new int[] {start[0],start[1],0});
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			for(int i =0;i<4;i++) {
				int nr = p[0] + dr[i];
				int nc = p[1] + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(res[nr][nc] != -1) continue;
				if(map[nr][nc] == 0) continue;
				
				res[nr][nc] = p[2]+1;
				q.offer(new int[] {nr,nc,p[2]+1});
				
			}
			
		}
		
		StringBuilder sb=  new StringBuilder();
		
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				sb.append(res[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
