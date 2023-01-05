package programmers.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class fibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N));
    }
    static Map<Integer, Integer> map = new HashMap<>();
    public static int solution(int n) {
        int answer = 0;
        answer = fibo(n);
        return answer;
    }
    public static int fibo(int n) {
        if (n==0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }
        int ans = ((fibo(n-1)) + (fibo(n-2)))%1234567;
        map.put(n,ans);
        return ans;
    }
}
