package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class maxNaturalNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long sum = 0;
        long v = 1;
        long cnt = -1;
        while(sum <= S) {
            sum += v;
            v+=1;
            cnt++;
        }
        System.out.println(cnt);

    }
}
