package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sumOfNaturalNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N));

    }

    static public int solution(int n) {
        int answer = 0;
        for (int i = 1; (i * (i + 1)) / 2 <= n; i++) {
            if (i % 2 == 1 && n % i == 0) {
                answer++;
                continue;
            }
            if (i % 2 == 0 && n % i == (i / 2)) {
                answer++;
                continue;
            }
        }
        return answer;
    }

}
