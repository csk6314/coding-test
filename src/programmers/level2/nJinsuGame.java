package programmers.level2;

public class nJinsuGame {
    public static void main(String[] args) {
        System.out.println(solution(16,16,2,1));
    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, k = 0; i < t * m; k++) {
            sb.append(Integer.toString(k, n).toUpperCase());
            i += getSize(k, n);
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            answer.append(sb.charAt(p + (m * i) - 1));
        }
        return answer.toString();
    }

    public static int getSize(int num, int n) {
        if (num == 0) return 0;
        return 1 + getSize(num / n, n);
    }

}
