
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		
		int[] res = new int[M];

		permutation(1,0,M,N,res);
	}
	
	public static void permutation(int cur,int depth,int M,int N,int[] res) {
		if(depth == M) {
			for(int i = 0;i<M;i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = cur;i<=N;i++) {
			res[depth] = i;
			permutation(i+1,depth+1,M,N,res);
		}
	}
}
