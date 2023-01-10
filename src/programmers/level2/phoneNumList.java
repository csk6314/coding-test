package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class phoneNumList {
    public static void main(String[] args) {
        String[] phone_book = {"12","1112","111134"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        if(phone_book.length==1) return false;
        HashSet<String> subStringSet = new HashSet<>();
        HashSet<Integer> lenSet = new HashSet<>();

        Arrays.sort(phone_book,new Comparator<>(){
            @Override
            public int compare(String s1, String s2) {
                return s1.length()-s2.length();
            }
        });

        for(int i =0;i<phone_book.length;i++) {
            lenSet.add(phone_book[i].length());
        }
        for(Integer i : lenSet) {
            for(int j =0;j<phone_book.length;j++) {
                if(phone_book[j].length() < i) continue;
                if(phone_book[j].length() == i) {
                    subStringSet.add(phone_book[j]);
                    continue;
                }
                if(subStringSet.contains(phone_book[j].substring(0,i))) {
                    answer = false;
                    break;
                }
            }
            if(!answer) break;

        }


        return answer;
    }
}
