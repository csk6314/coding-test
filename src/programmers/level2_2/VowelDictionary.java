package programmers.level2_2;

public class VowelDictionary {
    public static void main(String[] args) {
        System.out.println(solution("I"));
    }
    static int ans = 0;
    static boolean find = false;
    public static int solution(String word) {
        return dfs(word,"",0,0);
    }

    public static int dfs(String word,String search,int idx,int cnt) {
        if(ans > 0) return ans;
        if(idx>5) return cnt;
        if(idx>0) cnt++;
        if(search.equals(word)){
            ans = cnt;
        }
        //System.out.println(cnt);
        cnt = dfs(word, search+"A",idx+1,cnt);
        cnt =dfs(word, search+"E",idx+1,cnt);
        cnt =dfs(word, search+"I",idx+1,cnt);
        cnt =dfs(word, search+"O",idx+1,cnt);
        cnt =dfs(word, search+"U",idx+1,cnt);
        return cnt;

    }
}
