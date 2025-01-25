
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		
		
		ArrayList<Integer>[] adj = new ArrayList[N+1];
		
		for(int i = 1;i<N+1;i++) {
			adj[i] = new ArrayList<>();
		}
		
		int[] inDegree = new int[N+1];
		
		for(int i = 0;i<M;i++) {
			inputs = br.readLine().split(" ");
			int num = Integer.parseInt(inputs[0]);
			
			for(int k = 0;k<num-1;k++) {
				int src = Integer.parseInt(inputs[k+1]);
				int target = Integer.parseInt(inputs[k+2]);
				adj[src].add(target);
				inDegree[target] += 1;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1;i<N+1;i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			sb.append(v);
			sb.append('\n');
			cnt++;
			
			for(int target:adj[v]) {
				inDegree[target] -= 1;
				
				if(inDegree[target] == 0) {
					q.offer(target);
				}
			}
		}
		
		if(cnt < N) {
			System.out.println(0);
			return;
		}
		
		System.out.println(sb.toString());
		
	}
	

}
