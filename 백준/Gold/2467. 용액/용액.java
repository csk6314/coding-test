
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

			while (lo <= hi) {
				int mid = (lo + hi) / 2;

				int sum = liquids[i] + liquids[mid];

				if (sum > 0) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
			
			//System.out.println(i + " ====" + hi);

			if (hi < i + 1) {
				int sum = Math.abs(liquids[i] + liquids[i + 1]);
				if (min >= sum) {
					min = sum;
					ans = new int[] { i, i + 1 };
				}
				continue;
			}

			if (hi + 1 > N - 1) {
				int sum = Math.abs(liquids[i] + liquids[hi]);
				if (min >= sum) {
					min = sum;
					ans = new int[] { i, hi };
				}
				continue;
			}

			int leftSum = Math.abs(liquids[i] + liquids[hi]);
			int rightSum = Math.abs(liquids[i] + liquids[hi + 1]);
			
			if (leftSum < rightSum) {
				if (min >= leftSum) {
					min = leftSum;
					ans = new int[] { i, hi };
				}
			} else {
				if (min >= rightSum) {
					min = rightSum;
					ans = new int[] { i, hi + 1 };
				}
			}

		}

		for (int i = 0; i < 2; i++) {
			System.out.print(liquids[ans[i]] + " ");
		}

	}
}
