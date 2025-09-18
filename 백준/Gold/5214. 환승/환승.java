import java.io.*;
import java.util.*;

public class Main{
	static ArrayList<Integer>[] adj;
	static int[][] hyperLoops;
	static boolean[] visited;
	static boolean[] passedLoop;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int M = Integer.parseInt(input[2]);
		
		adj = new ArrayList[N+1];
		hyperLoops = new int[M][K];
		visited = new boolean[N+1];
		passedLoop = new boolean[M];
		
		for(int i = 0;i<N+1;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0;i<M;i++) {
			input = br.readLine().split(" ");
			
			for(int j = 0;j<input.length;j++) {
				int v = Integer.parseInt(input[j]);
				hyperLoops[i][j] = v;
				adj[v].add(i);
			}
		}
		
		System.out.println(bfs(1));
		
	}
	
	public static int bfs(int cur) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {cur, 1});
		visited[cur] = true;
		int ans = -1;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			if(p[0] == N) {
				ans = p[1];
				break;
			}
			
			for(int loopNum : adj[p[0]]) {
				if(passedLoop[loopNum]) continue;
				for(int next : hyperLoops[loopNum]) {
					if(visited[next]) continue;
					visited[next] = true;
					passedLoop[loopNum] = true;
					q.add(new int[] {next,p[1]+1});
	
				}
			}

			
			
		}
		
		return ans;
		
	}
}
