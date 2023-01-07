package programmers.level2;

import java.util.LinkedList;

public class cache {
    public static void main(String[] args) {
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        System.out.println(solution(3,cities));
    }
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();

        for(int i=0;i<cities.length;i++) {
            String city = cities[i].toUpperCase();
            int findIdx = list.indexOf(city);
            if(findIdx != -1) {
                list.remove(findIdx);
                list.add(city);
                answer++;
                continue;
            }
            list.add(city);
            if(list.size() > cacheSize) {
                list.remove(0);
            }
            answer+=5;

        }
        return answer;
    }
}
