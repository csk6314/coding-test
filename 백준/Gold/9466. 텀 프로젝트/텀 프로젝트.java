
import java.io.*;
import java.util.*;

public class Main{
	static int ans = 0;
	static Map<Integer,Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			int[] partner = new int[n+1];
			boolean[] visited = new boolean[n+1];
			
			String[] input = br.readLine().split(" ");
			for(int i = 1;i<=n;i++) {
				partner[i] = Integer.parseInt(input[i-1]);
			}
			
			for(int i = 1;i<=n;i++) {
				if(visited[i]) continue;
				ans += dfs(i,partner,visited);
				map.clear();
			}
			
			sb.append(ans);
			sb.append('\n');
			ans = 0;
			
		}
		
		System.out.println(sb.toString());
	}
	
	public static int dfs(int cur,int[] partner, boolean[] visited) {
		int next = partner[cur];
		visited[cur] = true;
		map.put(cur, map.size()+1);
		
		if(visited[next] && map.containsKey(next)) {
			return map.get(next) - 1;
		}
		
		if(visited[next]) {
			return map.size();
		}
		
		return dfs(next,partner,visited);
	}
}
