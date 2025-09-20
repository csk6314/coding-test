

import java.io.*;

public class Main {
	static int N, M;
	static int[][] pieces;
	static boolean[][] visited;
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		pieces = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String row = br.readLine();

			for (int j = 0; j < M; j++) {
				int v = row.charAt(j) - '0';
				pieces[i][j] = v;
			}
		}
		
		dfs(0);
		
		System.out.println(answer);

	}

	public static void dfs(int sum) {
		int[] pos = findNext();
		if(pos[0] == -1 && pos[1] == -1) {
			answer = Math.max(answer, sum);
			return;
		}
		
		int r  = pos[0];
		int c = pos[1];
		
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				// 아랫 방향으로 연결
				for (int j = 0; j < N; j++) {
					if(r+j >= N || visited[r+j][c]) break;
					cut(r,c,true,j+1,sum);
				}
				continue;
			}
			// 우측 방향으로 연결
			for (int j = 0; j < M; j++) {
				if(c+j >= M || visited[r][c+j]) break;
				cut(r,c,false,j+1,sum);
			}

		}
	}
	
	public static void cut(int r, int c, boolean isVertical, int size, int sum) {
		int value = 0;
		for (int i = 0; i < size; i++) {
			int nr = isVertical ? r+i : r;
			int nc = isVertical ? c : c + i;
			visited[nr][nc] = true;
			value += Math.pow(10, size - i - 1) * pieces[nr][nc];
		}
		dfs(sum + value);
		for (int i = 0; i < size; i++) {
			int nr = isVertical ? r+i : r;
			int nc = isVertical ? c : c + i;
			visited[nr][nc] = false;
		}

	}

	public static int[] findNext() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j])
					return new int[] { i, j };
			}
		}

		return new int[] { -1, -1 };
	}

}
