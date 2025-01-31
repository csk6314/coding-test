
import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static boolean[][] map,visited;
	static int[][][] dp;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new boolean[N][M];
		visited = new boolean[N][M];
		dp = new int[N][M][2];
		
		
		for(int i = 0;i<N;i++) {
			String row = br.readLine();
			for(int j = 0;j<M;j++) {
				char ch = row.charAt(j);
				
				if(ch=='0') {
					map[i][j] = true;
				}
				
				if(ch=='1') {
					dp[i][j][0] = 1;
				}
			}
		}
		
		int group = 0;
		
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(!visited[i][j] && map[i][j]) {
					ArrayList<int[]> posList = new ArrayList<>();
					dfs(i,j,posList);
					
					int cnt = posList.size() % 10;
					for(int[] pos: posList) {
						dp[pos[0]][pos[1]][0] = cnt;
						dp[pos[0]][pos[1]][1] = group;
					}
					
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
						if(groupCheck[dp[nr][nc][1]]) continue;
						if(map[nr][nc]) {
							dp[i][j][0] += dp[nr][nc][0];
							groupCheck[dp[nr][nc][1]] = true;
						}
						
					}
					
					dp[i][j][0] %= 10;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(!map[i][j]) {
					sb.append(dp[i][j][0]);
					continue;
				}
				
				sb.append(0);
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int r, int c, ArrayList<int[]> posList) {
		if(visited[r][c]) return;
		
		posList.add(new int[] {r,c});
		visited[r][c] = true;
		
		for(int i = 0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0 || nr>= N || nc < 0 || nc>=M) continue;
			
			if(!visited[nr][nc] && map[nr][nc]) {
				dfs(nr,nc,posList);
			}
		}
		
	}
}
