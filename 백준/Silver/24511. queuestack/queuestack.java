

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] isStack = new boolean[N];
		Queue<Integer> seq = new LinkedList<>();

		String[] input = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			isStack[i] = Integer.parseInt(input[i]) == 0 ? false : true;
		}

		input = br.readLine().split(" ");

		for (int i = N-1; i >=0; i--) {
			if (!isStack[i]) {
				seq.offer(Integer.parseInt(input[i]));
			}
		}

		int M = Integer.parseInt(br.readLine());

		input = br.readLine().split(" ");

		for (int i = 0; i < M; i++) {
			seq.offer(Integer.parseInt(input[i]));
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<M;i++) {
			sb.append(seq.poll() + " ");
		}
		
		System.out.println(sb.toString());

	}
}
