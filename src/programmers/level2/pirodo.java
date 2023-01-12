package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class pirodo {
    static List<Dungeon> dlist = new ArrayList<>();
    static boolean[] check = new boolean[8];

    static class Dungeon {
        int need, cost;

        public Dungeon(int need, int cost) {
            this.need = need;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        int k =80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(solution(k,dungeons));
    }

    public static int solution(int k, int[][] dungeons) {
        int answer = 0;
        for (int[] dungeon : dungeons) {
            if (dungeon[0] <= k) {
                dlist.add(new Dungeon(dungeon[0], dungeon[1]));
            }
        }

        answer = bruteForce(k, 0);
        return answer;
    }

    static int bruteForce(int k, int depth) {
        int max = depth;
        for (Dungeon d : dlist) {
            int idx = dlist.indexOf(d);
            if (d.need <= k && !check[idx]) {
                check[idx] = true;
                max = Math.max(bruteForce(k - d.cost, depth + 1), max);
                check[idx] = false;
            }
        }
        return max;
    }

}
