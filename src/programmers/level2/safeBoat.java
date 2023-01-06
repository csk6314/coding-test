package programmers.level2;

import java.util.Arrays;

public class safeBoat {
    public static void main(String[] args) {
        int[] people = {70,50,80,50};
        System.out.println(solution(people,100));
    }
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int size = people.length;
        int idx = size-1;
        int start_idx = 0;
        while(start_idx <= idx) {
            while(start_idx < idx && people[start_idx]+people[idx] >limit) {
                idx--;
                answer++;
            }
            answer++;
            start_idx++;
            idx--;
        }
        return answer;
    }
}
