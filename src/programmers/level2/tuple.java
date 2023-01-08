package programmers.level2;

import java.util.*;
import java.util.Map.Entry;
public class tuple {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
    }

    public static int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        s = s.replace("{", "").replace("}", "");
        String[] number = s.split(",");
        for (int i = 0; i < number.length; i++) {
            int num = Integer.parseInt(number[i]);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });
        int[] answer = new int[list.size()];
        int idx = 0;
        for (Entry<Integer, Integer> entry : list) {
            answer[idx++] = entry.getKey();
        }
        return answer;
    }

}
