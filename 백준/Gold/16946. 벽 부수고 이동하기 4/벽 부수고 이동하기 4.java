

import java.io.*;
import java.util.*;

public class Main{
	static int N,M;
	static boolean[][] map,visited;
	static int[][] dp;
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
		
		int group = 0;
		ArrayList<Integer> groupSize = new ArrayList<>();
		
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(!visited[i][j] && map[i][j]) {
					int size = dfs(i,j,group) % 10;
					
					groupSize.add(size);
					group++;
					
				}
			}
		}
		
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(!map[i][j]) {
					boolean[] groupCheck = new boolean[group+1];
					for(int k = 0;k<4;k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						
						if(nr<0 || nr>= N || nc < 0 || nc>=M) continue;
				
						if(map[nr][nc] && !groupCheck[dp[nr][nc]]) {
							dp[i][j] += groupSize.get(dp[nr][nc]);
							groupCheck[dp[nr][nc]] = true;
						}
						
					}
					
					dp[i][j] %= 10;
				}
			}
		}
		
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
	
	public static int dfs(int r, int c, int group) {
		if(visited[r][c]) return 0;
		
		visited[r][c] = true;
		dp[r][c] = group;
		
		int size = 1;
		
		for(int i = 0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0 || nr>= N || nc < 0 || nc>=M) continue;
			
			if(!visited[nr][nc] && map[nr][nc]) {
				size += dfs(nr,nc,group);
			}
		}
		
		return size;
		
	}
}
