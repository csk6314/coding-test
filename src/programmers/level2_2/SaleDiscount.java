package programmers.level2_2;

import java.util.HashMap;
import java.util.Map;

public class SaleDiscount {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution(want,number,discount));
    }


    static Map<String, Integer> wantMap = new HashMap<>();

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> tempMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length - 9; i++) {
            for (int j = 0; j < 10; j++) {
                tempMap.put(discount[i + j], tempMap.getOrDefault(discount[i + j], 0) + 1);
            }
            answer += compareWantAndDiscount(tempMap);
            tempMap.clear();
        }
        return answer;
    }

    public static int compareWantAndDiscount(Map<String, Integer> tempMap) {
        int res = 1;
        for (Map.Entry<String, Integer> entry : tempMap.entrySet()) {
            String name = entry.getKey();
            if (wantMap.get(name) != entry.getValue()) {
                res = 0;
                break;
            }
        }
        return res;
    }

}
