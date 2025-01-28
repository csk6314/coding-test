

import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static char[][] board;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Bead {
		int r, c;
		boolean isRed;

		public Bead(int r, int c, boolean isRed) {
			this.r = r;
			this.c = c;
			this.isRed = isRed;
		}

	}
	
	static class Beads {
		Bead[] beads;
		int cnt;
		
		public Beads(Bead[] beads,int cnt) {
			this.beads = beads;
			this.cnt = cnt;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];

		Bead[] beads = new Bead[2];
		int beadIdx = 0;
		
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = input.charAt(j);
				if (board[i][j] == 'R') {
					board[i][j] = '.';
					beads[beadIdx++] = new Bead(i,j,true);
					continue;
				}

				if (board[i][j] == 'B') {
					board[i][j] = '.';
					beads[beadIdx++] = new Bead(i,j,false);
					continue;
				}
			}
		}
	//	System.out.println(beads.toString());
		System.out.println(bfs(beads));
	}
	
	public static int bfs(Bead[] beads) {
		Queue<Beads> q = new LinkedList<>();
		
		q.offer(new Beads(beads,0));
		while(!q.isEmpty()) {
			Beads p = q.poll();
			Bead b1 = p.beads[0];
			Bead b2 = p.beads[1];
			int pcnt = p.cnt;
		//	System.out.println(pcnt);
			if(pcnt > 9) continue;
			
			for(int i = 0;i<4;i++) {
				Bead[] nbeads = new Bead[2];
				nbeads[0] = new Bead(b1.r,b1.c,b1.isRed);
				nbeads[1] = new Bead(b2.r,b2.c,b2.isRed);
				
				int flag = inclineBoard(nbeads,i);
				if(flag == 2) {
					continue;
				}
				if(flag == 1) {
					return p.cnt + 1;
				}
				
				q.offer(new Beads(nbeads,pcnt+1));
				
			}
		}
		
		return -1;
	}
	public static int inclineBoard(Bead[] beads, int dir) {
		// dir 0 = 아래, 1 = 오른쪽, 2 = 위, 3 = 왼쪽
		// return 0 = keep going, 1 = red out, 2 = blue out

		Arrays.sort(beads, new Comparator<Bead>() {
			@Override
			public int compare(Bead b1, Bead b2) {
				if (dir == 0) {
					return b2.r - b1.r;
				}
				if (dir == 1) {
					return b2.c - b1.c;
				}
				if (dir == 2) {
					return b1.r - b2.r;
				}
				if (dir == 3) {
					return b1.c - b2.c;
				}
				return b1.r - b2.r;
			}
		});
		
		int flag = 0;
		
		for (int i = 0;i<beads.length;i++) {
			Bead b = beads[i];
			boolean isRed = b.isRed;
			int nr = b.r + dr[dir];
			int nc = b.c + dc[dir];

			while (board[nr][nc] == '.' || board[nr][nc] == 'O') {
				if(flag != 1 && i > 0 && beads[i-1].r == nr && beads[i-1].c == nc) {
					break;
				}
				
				if (board[nr][nc] == 'O') {
					if(isRed) {
						flag = 1;
						break;
					}
					
					if(!isRed) {
						return 2;
					}
					
				}

				b.r = nr;
				b.c = nc;
				nr = b.r + dr[dir];
				nc = b.c + dc[dir];
			}
		}

		return flag;
	}

}
