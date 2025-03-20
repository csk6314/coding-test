function solution(n, bans) {
    let answer = '';
    
    bans.sort((a,b)=>{
        if(a.length === b.length) {
            if(a>b) {
                return 1;
            }
            if(a===b) {
                return 0;
            }
            if(a<b) {
                return -1;
            }
        }
        return a.length - b.length;
    });
    
    //console.log(bans);
    
    bans.forEach((ban)=>{
        const num = convertToNum(ban);
        if(num <= n ) {
            n++;
        } 
        
    });
    
    //console.log(convertToAlphabet(n));
    
    answer = convertToAlphabet(n);
    return answer;
}

function convertToAlphabet(num) {
    const charArr = [];
   // console.log(num);
    while(num > 0) {
        let rest = num % 26;
        num = Math.floor(num / 26);
        
        if(rest === 0 && num > 0) {
            rest = 26;
            num -= 1;
        }
  //      console.log(rest);
        charArr.push(rest + 'a'.charCodeAt(0) - 1);
    }
    
    charArr.reverse();
    return String.fromCharCode(...charArr);
}

function convertToNum(str) {
    let converted = 0n;
    
    for(let n = str.length-1;n>=0;n--) {
        converted += BigInt(getCharNum(str, n)) * BigInt((26**(str.length - (n+1))));
    }
    
    return converted;
}

function getCharNum(str,idx) {
    return str.charCodeAt(idx) - 'a'.charCodeAt(0) + 1;
}