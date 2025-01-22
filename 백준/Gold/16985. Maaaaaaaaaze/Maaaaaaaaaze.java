
import java.util.*;
import java.io.*;

public class Main {
	static final int SIZE = 5;
	static int[] dz = { 1, 0, 0, -1, 0, 0 };
	static int[] dr = { 0, 1, 0, 0, -1, 0 };
	static int[] dc = { 0, 0, 1, 0, 0, -1 };

	static int[][][] maze;
	static int[] plateList = new int[5];
	static boolean[] visited = new boolean[5];

	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		maze = new int[SIZE][SIZE][SIZE];

		for (int i = 0; i < SIZE * SIZE; i++) {
			String[] input = br.readLine().split(" ");
			int z = i / 5;
			int r = i % 5;
			for (int j = 0; j < SIZE; j++) {
				int v = Integer.parseInt(input[j]);
				maze[z][r][j] = v;
			}
		}

		dfs(0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	public static void dfs(int dep) {
		if (dep == SIZE * 2) {
			int[][][] temp = new int[SIZE][SIZE][SIZE];

			for (int i = 0; i < SIZE; i++) {
				temp[i] = maze[plateList[i]];
			}

			int cnt = bfs(new int[] { 0, 0, 0 }, temp);

			if (cnt < 0)
				return;
			ans = Math.min(ans, cnt);
			return;
		}

		if (dep >= SIZE) {
			for (int i = 0; i < 5; i++) {
				if (!visited[i]) {
					visited[i] = true;
					plateList[dep - SIZE] = i;
					dfs(dep + 1);
					visited[i] = false;
				}
			}
			return;
		}

		int[][] plate = maze[dep];
		for (int i = 0; i < 4; i++) {
			dfs(dep + 1);
			rotatePlate(plate);
		}
	}

	public static int bfs(int[] start, int[][][] temp) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[SIZE][SIZE][SIZE];
		q.offer(new int[] { start[0], start[1], start[2], 0 });
		visited[start[0]][start[1]][start[2]] = true;

		int[] end = { SIZE - start[0] - 1, SIZE - start[1] - 1, SIZE - start[2] - 1 };

		if (temp[start[0]][start[1]][start[2]] == 0 || temp[end[0]][end[1]][end[2]] == 0)
			return -1;

		while (!q.isEmpty()) {
			int[] p = q.poll();

			if (p[0] == end[0] && p[1] == end[1] && p[2] == end[2]) {
				return p[3];
			}

			for (int i = 0; i < 6; i++) {
				int nz = p[0] + dz[i];
				int nr = p[1] + dr[i];
				int nc = p[2] + dc[i];

				if (nz < 0 || nr < 0 || nc < 0 || nz >= SIZE || nr >= SIZE || nc >= SIZE)
					continue;

				if (!visited[nz][nr][nc] && temp[nz][nr][nc] == 1) {
					q.offer(new int[] { nz, nr, nc, p[3] + 1 });
					visited[nz][nr][nc] = true;
				}
			}
		}

		return -1;

	}

	public static void rotatePlate(int[][] plate) {
		int[][] temp = new int[SIZE][SIZE];

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				temp[i][j] = plate[SIZE - j - 1][i];
			}
		}

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				plate[i][j] = temp[i][j];
			}
		}

	}

}
