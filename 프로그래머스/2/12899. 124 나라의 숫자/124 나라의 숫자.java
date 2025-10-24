class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        
        int carry = 0;
        int rest = 0;
        while(n/3 != 0 ) {
            rest = n%3;
            n /= 3;
            
            if(carry > 0) {
                carry --;
                rest -= 1;
            }
            
            if (rest <= 0 && n > 0) {
                carry ++;
                rest += 3;
            }
            
            answer.append(convertTo124(rest));
        }
        
        rest = n;
        
        if(carry > 0) {
            carry --;
            rest -= 1;
        }
        
        if(rest > 0 ) {
            answer.append(convertTo124(rest));
        }
        
        answer.reverse();
        
        return answer.toString();
    }
    
    public int convertTo124(int rest) {
        if (rest == 1) {
            return 1;
        } else if (rest == 2) {
            return 2;
        } else if(rest==3) {
            return 4;
        }
        
        return 0;
    }
}

// 11 -> 42 12 -> 44 13 -> 111  14 -> 112 15-> 114
/*
12 / 3 = 4 , 0 -> 3 , 3
4 / 3 = 1 , 1
1 / 3 = 0 , 1
110

14 / 3 = 4 , 2 -> 1, 1, 2

15 / 3 = 5 , 0 -> 1, 1, 4
5 / 3 = 1 , 2
2 / 3 = 0 , 2
**/