
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] pos = new int[N][2];
		
		for(int i = 0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			pos[i][0] = Integer.parseInt(input[0]);
			pos[i][1] = Integer.parseInt(input[1]);
		}
		
		long sum1 = 0;
		long sum2 = 0;
		
		
		
		for(int i = 0;i<N-1;i++) {
			sum1 += (long)pos[i][0] * pos[i+1][1];
			sum2 += (long)pos[i+1][0] *  pos[i][1];
		}
		
		sum1 += (long)pos[N-1][0] * pos[0][1];
		sum2 += (long)pos[0][0] * pos[N-1][1];
		
		double ans = 0.5 * Math.abs(sum1 - sum2);
		
		
		System.out.printf("%.1f",ans);
		
		
		
	}
}
