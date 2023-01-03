package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class treasure {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Integer[] B = new Integer[N];

        // A 배열 입력
        String[] input = br.readLine().split(" ");
        int value;
        for (int i =0;i<N;i++) {
            value = Integer.parseInt(input[i]);
            A[i] = value;
        }
        // B 배열 입력
        input = br.readLine().split(" ");
        for (int i =0;i<N;i++) {
            value = Integer.parseInt(input[i]);
            B[i] = value;
        }

        // A 오름 차순 정렬
        Arrays.sort(A);
        // B 내림 차순 정렬
        Arrays.sort(B, new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        int ans = 0;
        for(int i =0;i<N;i++) {
            ans += A[i] * B[i];
        }
        System.out.println(ans);

    }
}
