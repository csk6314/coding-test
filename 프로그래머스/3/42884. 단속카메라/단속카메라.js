function solution(routes) {
    var answer = 0;
    
    const cctvCoverArea = [];
    
    routes.sort((a,b)=>a[0]-b[0]);
    
    if(routes.length === 1) return 1;
    
    let idx = 0;
    
    for(let i = 0;i<routes.length;i++) {
        if(cctvCoverArea.length === 0) {
            cctvCoverArea.push(routes[i]);
            continue;
        }
        
        const route = routes[i];
      //  console.log(cctvCoverArea);
        for(;idx<cctvCoverArea.length;idx++) {
            const area = cctvCoverArea[idx];
            
            if(route[0] <= area[1]) {
                area[0] = route[0];
                area[1] = route[1] < area[1] ? route[1] : area[1];
                break;
            }
        }
        
        if(idx === cctvCoverArea.length) {
            cctvCoverArea.push(route);
        }
    }
    //console.log(cctvCoverArea);
    answer = cctvCoverArea.length;
    
    return answer;
}