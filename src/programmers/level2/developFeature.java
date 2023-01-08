package programmers.level2;

import java.util.Arrays;

public class developFeature {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses,speeds)));
    }
        public static int[] solution(int[] progresses, int[] speeds) {
            int[] answer = new int[100];
            int size = progresses.length;
            int idx = 0;
            int day = 0;
            while(idx<size) {
                while(progresses[idx] < 100) {
                    for(int i =0;i<size;i++) {
                        progresses[i] += speeds[i];
                    }
                }
                int done = idx+1;
                int cnt = 1;
                while(done < size && progresses[done] >= 100) {
                    done++;
                    cnt++;
                }
                idx=done;
                answer[day++] = cnt;
            }
            int[] cpy = new int[day];
            System.arraycopy(answer,0,cpy,0,day);
            return cpy;
        }
}
