

import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static boolean[][] map,visited;
	static int[][] dp;
	static Queue<int[]> edges = new LinkedList<>();
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new boolean[N][M];
		visited = new boolean[N][M];
		dp = new int[N][M];
		
		
		for(int i = 0;i<N;i++) {
			String row = br.readLine();
			for(int j = 0;j<M;j++) {
				char ch = row.charAt(j);
				
				if(ch=='0') {
					map[i][j] = true;
				}
				
				if(ch=='1') {
					dp[i][j] = 1;
				}
			}
		}
		
		// grouping with size
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(!visited[i][j] && map[i][j]) {
					int size = dfs(i,j);
					
					while(!edges.isEmpty()) {
						int[] p = edges.poll();
						
						dp[p[0]][p[1]] += size;
						dp[p[0]][p[1]] %= 10;
						visited[p[0]][p[1]] =false;
					}
					
				}
			}
		}
		
		//출력
		StringBuilder sb = new StringBuilder();
		
		for(int i =0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(!map[i][j]) {
					sb.append(dp[i][j]);
					continue;
				}
				
				sb.append(0);
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	public static int dfs(int r, int c) {
		if(visited[r][c]) return 0;
		
		visited[r][c] = true;
		
		int size = 1;
		
		for(int i = 0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0 || nr>= N || nc < 0 || nc>=M) continue;
			if(visited[nr][nc]) continue;
			
			if(map[nr][nc]) {
				size += dfs(nr,nc);
				continue;
			}
			
			edges.add(new int[] {nr,nc});
			visited[nr][nc] = true;
		}
		
		return size;
		
	}
}
