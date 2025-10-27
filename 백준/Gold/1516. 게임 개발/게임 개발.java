
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);

        ArrayList<int[]>[] adj = new ArrayList[N+1];

        for(int i = 0;i<N+1;i++) {
            adj[i] = new ArrayList<>();
        }

        int[] inDegrees = new int[N+1];

        for(int i = 0;i<N;i++) {
            input = br.readLine().split(" ");
            int d = i+1;
            int t = Integer.parseInt(input[0]);

            // 시작 건물은 임의 점과 연결
            if(input.length == 2) {
                adj[0].add(new int[]{d,t});
                inDegrees[d]++;
                continue;
            }

            for(int j = 1;j<input.length-1;j++) {
                int s = Integer.parseInt(input[j]);
                inDegrees[d]++;
                adj[s].add(new int[]{d,t});
            }
        }

        int[] time = new int[N+1];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<N+1;i++) {
            if(inDegrees[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int v = q.poll();

            for(int[] edge : adj[v]) {
                int d = edge[0];
                int w = edge[1];

                inDegrees[d]--;
                time[d] = Math.max(time[d], time[v] + w);
                if(inDegrees[d] == 0) {
                    q.offer(d);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 1;i<N+1;i++) {
            sb.append(time[i]).append("\n");
        }

        System.out.print(sb.toString());

    }
}
