function solution(h1, m1, s1, h2, m2, s2) {
    var answer = 0;
    
    // (h*3600 + m * 60 + s)/12*3600, m*60 + s / 3600, s/60 
    // compare(h,m), compare(h,s)
    // eq({h,m},{nh,nm}), eq({h,s},{nh,ns});
    
    const getDegree = (h, m, s, type) => {
        if(type === 'hour') {
            return ((h%12)*3600 + m*60 + s)/(12*3600);
        }
        if(type==='min') {
            return (m*60 + s) / (60*60);
        }
        
        return s/60;
    }
    
    const compare = (h, m, s,isMin) => {
        const vDegree = getDegree(h,m,s, isMin ? 'min' : 'hour');
        const sDegree = getDegree(h,m,s,'sec');
        
        if(sDegree > vDegree ) return 1;
        if(sDegree === vDegree) return 0;
        return -1;
    }
    
    //compare(h1,m1,s1,true);
    
    while(!(h1===h2 && m1 === m2 && s1 === s2)) {
        let nh = h1;
        let nm = m1;
        let ns = s1;
        
  
        
        ns++;
        
        

        if(compare(nh,nm,ns,true) === -compare(h1,m1,s1,true)) {
            answer++;
         //   console.log("분침겹침",h1,m1,s1);
        }
        
        if(compare(nh,nm,ns,false) === -compare(h1,m1,s1,false)) {
            answer++;
           // console.log("시침겹침",h1,m1,s1);
        }
        if(compare(h1,m1,s1,true) === 0 || compare(h1,m1,s1,false) === 0) {
            answer++;
            //console.log(h1,m1,s1);
        }
        
        if(ns > 59) {
            ns = 0;
            nm++;
        }
        if(nm > 59) {
            nm = 0;
            nh ++;
        }
        
        h1 = nh;
        m1 = nm;
        s1 = ns;
    }
    
        if(compare(h1,m1,s1,true) === 0 || compare(h1,m1,s1,false) === 0) {
            answer++;
        }
    
    
    
    return answer;
}