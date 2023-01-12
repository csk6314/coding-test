package programmers.level2;

import java.util.PriorityQueue;

public class scovile {
    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12};
        System.out.println(solution(scoville,7));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int sco : scoville) {
            pq.offer(sco);
        }
        while(pq.size()>1) {
            if(pq.peek() >= K) {
                break;
            }
            int sco_1 = pq.poll();
            int sco_2 = pq.poll();
            int newSco = sco_1 + (sco_2*2);
            pq.offer(newSco);
            answer++;
        }
        if(pq.peek() < K) {
            return -1;
        }
        return answer;

    }
}
