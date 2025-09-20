

import java.io.*;
import java.util.*;

public class Main{
	
	static int N,M,K;
	static int[][] A;
	static int[][] field;
	static ArrayList<Integer>[][] trees;
	static ArrayList<Integer>[][] deadTrees;
	static int[] dr = { 1,0,-1,0,1,1,-1,-1};
	static int[] dc = {0,1,0,-1,1,-1,1,-1};
	
	public static void main(String[] args) throws IOException {
		init();
		for(int i = 0;i<K;i++) {
		//	System.out.println(i+1 + "년차 시작");
			spring();
			summer();
			fall();
			winter();
		//	System.out.println(i+1 + "년차 종료");
		}
		
		System.out.print(getResult());
		
		
		
	}
	
	public static void spring() {
		for(int i = 1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				if(trees[i][j].size() > 0) {
					ArrayList<Integer> newTree = new ArrayList<>();
					Collections.sort(trees[i][j], Collections.reverseOrder());
					
					for(int k = trees[i][j].size()-1;k>=0;k--) {
						int age = trees[i][j].get(k);
						
						if(field[i][j] - age >= 0) {
							field[i][j] -= age;
							newTree.add(age+1);
							continue;
						}
						
						deadTrees[i][j].add(age/2);

					}
					
					trees[i][j].clear();
					
					for(int newAge : newTree) {
						trees[i][j].add(newAge);
					}
					
				}
			}
		}
		
	}
	
	public static void summer() {
		for(int i = 1;i<=N;i++) {
			for(int j = 1;j<=N;j++) {
				if(deadTrees[i][j].size() > 0) {
					for(int age : deadTrees[i][j]) {
						field[i][j] += age;
					}
					deadTrees[i][j].clear();
				}
			}
		}
	}
	
	public static void fall() {
		int[][] temp = new int[N+1][N+1];
		
		for(int i = 1;i<=N;i++) {
			for(int j = 1;j<=N;j++) {
				if(trees[i][j].size() > 0) {
					for(int age : trees[i][j]) {
						if(age % 5 == 0) {
							for(int k = 0;k<8;k++) {
								int nr = i + dr[k];
								int nc = j + dc[k];
								
								if(nr < 1 || nr > N || nc < 1 || nc > N) continue;
						//		System.out.println(nr + " , " + nc + " , 복제");
								temp[nr][nc]++;
							}
						}
					}
				}
			}
		}
		
		for(int i =1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				if(temp[i][j] > 0) {
					for(int k = 0;k<temp[i][j];k++) {
						trees[i][j].add(1);
					}
				}
			}
		}
	}
	
	public static void winter() {
		for(int i = 1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				field[i][j] += A[i][j];
			}
		}
	}
	
	public static int getResult() {
		int sum = 0;
		for(int i =1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				sum += trees[i][j].size();
			//	System.out.println(i + " , " + j + " = " + trees[i][j].size());
			}
		}
		return sum;
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		
		field = new int[N+1][N+1];
		A = new int[N+1][N+1];
		trees = new ArrayList[N+1][N+1];
		deadTrees = new ArrayList[N+1][N+1];
		
		for(int i = 1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				field[i][j] = 5;
			}
		}
		
		for(int i = 1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				trees[i][j] = new ArrayList<>();
				deadTrees[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 1;i<=N;i++) {
			input = br.readLine().split(" ");
			for(int j = 1;j<input.length+1;j++) {
				A[i][j] = Integer.parseInt(input[j-1]);
			}
		}
		
		for(int i = 0;i<M;i++) {
			input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			int age = Integer.parseInt(input[2]);
			
			trees[r][c].add(age);
		}
	}

}
