package programmers.level2;

public class kPrime {
    public static void main(String[] args) {
        System.out.println(solution(437674,3));

    }
    static int solution(int n,int k) {
        int answer = 0;
        //System.out.println(Integer.toString(n,k));
        String cvtNumber = Integer.toString(n,k);
        String[] pstr = cvtNumber.split("0");
        for(int i =0;i<pstr.length;i++) {
            if(pstr[i].isEmpty()) continue;
            long p = Long.parseLong(pstr[i]);
            if(p<2) continue;
            boolean isPrime = true;
            for(int j = 2;j<=Math.sqrt(p);j++) {
                if(p%j == 0) {
                    isPrime=false;
                    break;
                }
            }
            if(isPrime)answer++;
        }
        return answer;
    }
}
