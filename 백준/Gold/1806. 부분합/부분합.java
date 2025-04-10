import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		int N = Integer.parseInt(inputs[0]);
		int S = Integer.parseInt(inputs[1]);
		
		long[] seq = new long[N+1];
		
		inputs = br.readLine().split(" ");
	
		seq[1] = Integer.parseInt(inputs[0]);
		for(int i = 2;i<N+1;i++) {
			seq[i] = seq[i-1] + Integer.parseInt(inputs[i-1]);
		}
		
		int start = 1;
		int end = 2;
		
		int minLen = Integer.MAX_VALUE;
		
		while(start < end) {
		//	System.out.println(start + " , " + end);
			long v = seq[end-1] - seq[start-1];
			int len = end - start;
			if(v >= S) {
				minLen = Math.min(minLen, len);
				start++;
				continue;
			}
			if(end == N+1) {
				break;
			}
			end ++;
		}
		
		System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
		
		
	}
}
