package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class camouflage {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
    public static int solution(String[][] clothes) {
        int answer = 0;
        Map<String,Integer> map = new HashMap<>();
        for(int i =0;i<clothes.length;i++) {
            String clothesClass = clothes[i][1];
            String clothesName = clothes[i][0];
            if(map.containsKey(clothesClass)) {
                int v = map.get(clothesClass);
                map.put(clothesClass,v+1);
                continue;
            }
            map.put(clothesClass,1);
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            answer = (answer==0) ? (v+1) : (answer*(v+1));

        }
        answer--;
        return answer;
    }
}
