
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		int[] tshirts = new int[6];
		
		for(int i = 0;i<6;i++) {
			tshirts[i] = Integer.parseInt(inputs[i]);
		}
		
		int[] setNum = new int[2];
		inputs = br.readLine().split(" ");
		for(int i = 0;i<2;i++) {
			setNum[i] = Integer.parseInt(inputs[i]);
		}
		
		
		int cnt = 0;
		for(int i =0;i<6;i++) {
			cnt += tshirts[i] / setNum[0];
			cnt += (tshirts[i] % setNum[0] > 0 ? 1 : 0);
		}
		
		int penCnt = N/setNum[1];
		int penRest = N%setNum[1];
		
		System.out.println(cnt);
		System.out.println(penCnt + " " + penRest);
		
	}
}
