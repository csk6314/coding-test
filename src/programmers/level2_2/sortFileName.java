package programmers.level2_2;

import java.util.Arrays;

public class sortFileName {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(solution(files)));
    }
    public static String[] solution(String[] files) {
        FileName[] fn = new FileName[files.length];
        for(int i =0;i<files.length;i++) {
            fn[i] = splitName(files[i]);
        }
        Arrays.sort(fn);
        String[] answer = new String[files.length];
        int idx = 0;
        for(FileName fileName : fn) {
            answer[idx++] = fileName.toString();
        }
        return answer;
    }
    static class FileName implements Comparable<FileName>{
        String head,number,tail;
        public FileName(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(FileName f1) {
            String myHead = getHead();
            String yourHead = f1.getHead();
            if(myHead.equals(yourHead)) {
                return getNum() - f1.getNum();
            }
            return myHead.compareTo(yourHead);
        }

        @Override
        public String toString() {
            return head + number + tail;
        }

        public String getHead() {
            return this.head.toUpperCase();
        }

        public int getNum() {
            return Integer.parseInt(number);
        }
    }

    public static FileName splitName(String file) {
        String head = "";
        String number = "";
        String tail = "";
        int idx = 0;
        for(int i =0;i<file.length();i++) {
            char ch = file.charAt(i);

            if(idx==0 && Character.isDigit(ch)) {
                head = file.substring(idx,i);
                idx=i;
                continue;
            }

            if(idx>0) {
                if(i-idx+1 > 5 || !Character.isDigit(ch)) {
                    number = file.substring(idx,i);
                    idx = i;
                    tail = file.substring(idx);
                    break;
                }
            }
        }

        if(number.isEmpty()) {
            number = file.substring(idx);
            tail="";
        }

        // System.out.println("head : " + head);
        // System.out.println("num : " + number);
        // System.out.println("tail : " + tail);

        return new FileName(head,number,tail);
    }
}
