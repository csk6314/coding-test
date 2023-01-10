package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class printer {
    static class Pair {
        int idx,priority;
        public Pair(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

    }
    public static  void main(String[] args) {
        int[] priorities = {2,1,3,2};

        System.out.println(solution(priorities,2));
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pair> pq = new LinkedList<>();
        for(int i =0;i<priorities.length;i++) {
            pq.offer(new Pair(i,priorities[i]));
        }
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            boolean isMax = true;
            for(Pair p2 : pq) {
                if(p2.priority > p.priority) {
                    isMax = false;
                    break;
                }
            }
            if(!isMax) {
                pq.offer(p);
                continue;
            }
            answer++;
            if(p.idx == location) {
                return answer;
            }


        }
        return answer;
    }
}
