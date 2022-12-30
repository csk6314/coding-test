package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sugarDelivering {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxFivePB = N/5;
        int threePB = 0;
        int remainder;
        boolean flag = false;

        while (maxFivePB >= 0) {
            remainder = N - (maxFivePB*5);
            if(remainder%3 ==0) {
                threePB = remainder/3;
                flag=true;
                break;
            }
            maxFivePB--;
        }
        if(flag) {
            System.out.println(maxFivePB + threePB);
        } else {
            System.out.println(-1);
        }

    }
}
