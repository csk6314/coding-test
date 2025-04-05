import java.io.*;

public class Main {
	static int[][] map;
	static int N,M;
	static boolean[][] visited;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0;i<N;i++) {
			input = br.readLine().split(" ");
			
			for(int j = 0;j<M;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				visited[i][j] = true;
				dfs(new int[] {i,j},null,0,map[i][j],false);
				visited[i][j] = false;
			}
		}
		
		System.out.println(ans);
		
		
	}
	
	public static void dfs(int[] current, int[] prev,int cnt,int sum,boolean isMutate) {
		
	//	System.out.println(sum + " " + cnt);
		if(cnt == 3) {
			//System.out.println(sum);
			ans = Math.max(ans, sum);
			return;
		}
		
		if(cnt == 2 && !isMutate) {
			dfs(prev,current,cnt,sum,true);
		}
		
		for(int i = 0;i<4;i++) {
			int nr = current[0] + dr[i];
			int nc = current[1] + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			
			if(!visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(new int[] {nr,nc},current,cnt+1,sum + map[nr][nc],false);
				visited[nr][nc] = false;
			}
		}
	}
	
}
