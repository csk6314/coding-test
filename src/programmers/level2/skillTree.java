package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class skillTree {
    public static void main(String[] args) {
        String[] stree = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution("CBD",stree));
    }

    static Map<Character, Byte> skillMap = new HashMap<>();

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill.length(); i++) {
            char ch = skill.charAt(i);
            skillMap.put(ch, (byte) i);
        }
        for (int i = 0; i < skill_trees.length; i++) {
            if (canLearnSkill(skill_trees[i])) {
                answer++;
            }
        }
        return answer;
    }

    public static boolean canLearnSkill(String skill) {
        for (int j = 0, cnt = 0; j < skill.length(); j++) {
            char ch = skill.charAt(j);
            if (skillMap.containsKey(ch)) {
                if (cnt == skillMap.get(ch)) {
                    cnt++;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
