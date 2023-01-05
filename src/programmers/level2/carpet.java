package programmers.level2;

public class carpet {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        System.out.println(solution(brown,yellow)[0] + " " + solution(brown,yellow)[1]);
    }
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int wplush = (brown-4)/2;
        int height = 0;
        for(int i=1;i<=wplush/2;i++) {
            if(i*(wplush-i)==yellow) {
                height = i;
                break;
            }
        }
        int width = (wplush-height)+2;
        height+=2;
        answer[0] = width;
        answer[1] = height;


        return answer;
    }
}
