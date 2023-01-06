package programmers.level2;

public class tableExpectation {
    public static void main(String[] args) {
        System.out.println(solution(8,4,7));
    }

        public static int solution(int n, int a, int b)
        {
            int answer = 0;
            int aRound=a;
            int bRound=b;
            int round = 0;
            while(aRound!=bRound) {
                aRound = ((aRound-1)/2+1);
                bRound = ((bRound-1)/2+1);
                round++;
            }
            answer = round;
            return answer;
        }
}
