package programmers.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nextBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N));
    }
    public static int solution(int n) {
        int answer = 0;
        int size = getSize(n);
        while (getSize(++n) != size) {}
        answer = n;
        return answer;
    }
    public static int getSize(int n) {
        if (n==0) return 0;
        return n%2 + getSize(n/2);
    }
}
