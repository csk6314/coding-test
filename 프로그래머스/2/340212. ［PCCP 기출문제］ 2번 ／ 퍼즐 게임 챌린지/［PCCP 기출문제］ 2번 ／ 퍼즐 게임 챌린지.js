function solution(diffs, times, limit) {
    const ans = binarySearch(diffs,times,limit);
    return ans;
}

const binarySearch = (diffs,times,limit) => {
    let left = 1;
    let right = 100000;
    
    while(left < right) {
        const mid = Math.floor((left+right)/2);
        //console.log(mid,getTimes(diffs,times,mid));
        
        if(check(getTimes(diffs,times,mid),limit)) {
            right = mid;
        } else {
            left = mid+1;
        }
    }
    
    return left;
    
    
}

const check = (totalTime, limit) => {
    return totalTime <= limit;
}

const getTimes = (diffs, times, level) => {
    let totalTime = 0;
    for(let i = 0;i<diffs.length;i++) {
        const gap = diffs[i] - level;
        // 퍼즐이 더 어려운 경우
        if(gap > 0) {
            totalTime += gap * (times[i-1] + times[i]);
            totalTime += times[i];
            continue;
        }
        
        totalTime += times[i];
        
    }    
    return totalTime;
}


