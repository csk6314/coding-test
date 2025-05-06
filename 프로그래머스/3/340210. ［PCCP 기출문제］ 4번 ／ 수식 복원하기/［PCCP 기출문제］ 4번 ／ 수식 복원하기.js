function solution(expressions) {
    var answer = [];
    const canBase = new Array(10).fill(true);
    const unSolvedExp = [];
    const solvedExp = [];
    let max = 1;
    for(let i = 0;i<expressions.length;i++) {
        const exp = expressions[i].split(" ");
            
        for(let i = 0;i<exp[0].length;i++) {
            max = Math.max(Number(exp[0].charAt(i)),max);
        }
        
        for(let i = 0;i<exp[2].length;i++) {
            max = Math.max(Number(exp[2].charAt(i)),max);
        }
        
        if(exp[4] === 'X') {
            unSolvedExp.push(expressions[i]);
            continue;
        }
        
        solvedExp.push(expressions[i]);
        for(let i = 0;i<exp[4].length;i++) {
            max = Math.max(Number(exp[4].charAt(i)),max);
        }
        
    }
    setMinBase(max,canBase);
    
    for(let i = 0;i<solvedExp.length;i++) {
        const exp = solvedExp[i].split(" ");
        
        for(let j = 9;j>=2;j--) {
            if(!canBase[j]) break;
            if(exp[1] === "+") {
                if(Number(exp[4]) !== add(exp[0],exp[2],j)) {
                    canBase[j] = false;
                }
                continue;
            }
            
            if(exp[1] === "-") {
                if(Number(exp[4]) !== subtract(exp[0],exp[2],j)) {
                    canBase[j] = false;
                }
                continue;
            }
            
        }
    }
    
   // console.log(canBase);

    for(let i = 0;i<unSolvedExp.length;i++) {
        const exp = unSolvedExp[i].split(" ");
        let res = -1;
        let FLAG = false;
        
        for(let j = 9;j>=2;j--) {
            if(!canBase[j]) continue;
            if(exp[1] === "+") {
                if(res === -1) {
                    res = add(exp[0],exp[2],j);
                    continue;
                }
                const otherRes = add(exp[0],exp[2],j);
                if(otherRes !== res) {
                    answer.push(unSolvedExp[i].replace("X","?"));
                    FLAG = true;
                    break;
                }
                continue;
            }
            
            if(exp[1] === "-") {
                if(res === -1) {
                    res = subtract(exp[0],exp[2],j);
                    continue;
                }
                const otherRes = subtract(exp[0],exp[2],j);
                if(otherRes !== res) {
                    answer.push(unSolvedExp[i].replace("X","?"));
                    FLAG = true;
                    break;
                }
                continue;
            }
        }
        if(FLAG) continue;
        answer.push(unSolvedExp[i].replace("X",res));
    }
    
    return answer;
}

function setMinBase(max, canBase) {
    for(let i = 2; i<=max;i++) {
        canBase[i] = false;
    }
}

function add(a, b, base) {
    a = a.padStart(2,"0");
    b = b.padStart(2,"0");
    let p = 0;
    const result = new Array(3).fill("0");
    
    
    
    //자리별 덧셈
    for(let i = 1;i>=0;i--) {
        const curA = Number(a.charAt(i) ? a.charAt(i) : "0");
        const curB = Number(b.charAt(i) ? b.charAt(i) : "0");
        
        const res = ((curA + curB + p) % base);
        
        p = Math.floor((curA + curB + p) / base);
        
        result[i+1] = "" + res; 
    }    
    
    result[0] = "" + p;
    
    return Number(result.join(""));
}

function subtract(a, b, base) {
     a = a.padStart(2,"0");
    b = b.padStart(2,"0");
    let p = 0;
    const result = new Array(3).fill("0");
    
    
    
    //자리별 뺄셈
    for(let i = 1;i>=0;i--) {
        let curA = Number(a.charAt(i) ? a.charAt(i) : "0") - p;
        p=0;
        const curB = Number(b.charAt(i) ? b.charAt(i) : "0");
        
        
        if(curA < curB) {
            p+=1;
            curA += base;
        }
        
        const res = ((curA - curB) % base);
        
        result[i+1] = "" + res; 
    }    
    
    result[0] = "" + p;
    
    return Number(result.join(""));
}



/*
진수를 확실하게 유추할 수 있는 경우
덧셈 -> 자릿수 변화
뺄셈 -> 자릿수 변화

수식에 있는 숫자로 리미트 설정 가능

진수 계산 공식
*/