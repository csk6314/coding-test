
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static ArrayList<Integer>[] adj;
	static int[] childNums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1];
		
		for(int i = 1; i<N+1;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0;i<N-1;i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		
		childNums = new int[N+1];
		
		dfs(1,1);
		
		long ans =  (N-1) * getSubTreePair(N);
		
		
		//System.out.println(Arrays.toString(childNums));
		for(int i = 2;i<=N;i++) {
			ans -= getSubTreePair(N-childNums[i]);
		}
		
		System.out.println(ans);
	}
	
	public static long getSubTreePair(int N) {
		return 1L * N * (N-1) / 2;
	}

	public static int dfs(int cur,int prev) {
		//System.out.println(cur + " , " + prev);
		int childNum = 1;
		
		
		for(int v:adj[cur]) {
			if(v == prev) continue;
			childNum += dfs(v,cur);
		}
		
		childNums[cur] = childNum;
		
		return childNum;
	}
	

}