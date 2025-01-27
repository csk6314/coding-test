

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] liquids = new int[N];
		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			liquids[i] = Integer.parseInt(inputs[i]);
		}

		int min = Integer.MAX_VALUE;
		int[] ans = new int[2];

		for (int i = 0; i < N - 1; i++) {
			int lo = i + 1;
			int hi = N - 1;
			int res = i;
			
			
			
			while (lo <= hi) {
				int mid = (lo + hi) / 2;

				int sum = liquids[i] + liquids[mid];

				if (sum > 0) {
					hi = mid - 1;
					
				} else {
					lo = mid + 1;
					res = mid;
				}
			}
			// System.out.println(i + " ====" + hi);

			if (res >= i + 1) {
				int leftSum = Math.abs(liquids[i] + liquids[res]);
				if (min >= leftSum) {
					min = leftSum;
					ans = new int[] { i, res };
				}
			}
			if (res + 1 < N) {
				int rightSum = Math.abs(liquids[i] + liquids[res + 1]);

				if (min >= rightSum) {
					min = rightSum;
					ans = new int[] { i, res + 1 };
				}
			}

		}

		for (int i = 0; i < 2; i++) {
			System.out.print(liquids[ans[i]] + " ");
		}

	}
}
