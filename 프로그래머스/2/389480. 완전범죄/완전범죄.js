function solution(info, n, m) {
    var answer = -1;
    const dp = Array.from({length:info.length+1},()=>new Array(n).fill(null));
    
    dp[0][0] = 0;
    
    for(let i = 1;i<dp.length;i++) {
        for(let j = 0;j<dp[0].length - info[i-1][0];j++) {
            if(dp[i-1][j] !== null) {
                dp[i][j+info[i-1][0]] = dp[i-1][j]; 
            }        
        }
        
        for(let j = 0;j<dp[0].length;j++) {
            if(dp[i-1][j] !== null && dp[i-1][j] + info[i-1][1] < m) {
                if(dp[i][j] !== null) {
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+info[i-1][1]);
                }else {
                dp[i][j] = dp[i-1][j] + info[i-1][1];
                }
            }        
        }
    }
    
    for(let i = 0;i<n;i++) {
        if(dp[dp.length-1][i] !== null) {
            answer = i;
            break;
        }
    }
    
  //  console.log(dp);
    return answer;
}