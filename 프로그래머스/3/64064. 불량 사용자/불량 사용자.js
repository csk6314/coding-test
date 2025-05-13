function solution(user_id, banned_id) {
    var answer = 0;
    
    /*
        a:{
            children: {
                
            }
        }  
    */
    
    const root = {
        children: {},
        data: "",
    }
    
    const candidates = Array.from({length:banned_id.length},()=>[]);
    
    const combSet = new Set();
    
    const insertUser = (user_id) => {
        let cur = root;
        
        for(let i = 0;i<user_id.length;i++) {
            const ch = user_id.charAt(i);
            
            if(cur.children.hasOwnProperty(ch)) {
                cur = cur.children[ch];
                continue;
            }
            
            cur.children[ch] = {
                children:{},
                data: cur.data + ch,
            };
            
            cur = cur.children[ch];
        }
        
        cur.isEnd = true;
    }
    
    const getBannedCandidate = (cur, idx, idNum) => {
        const id = banned_id[idNum];
        //console.log(cur,idx,id);
        if(idx === id.length && cur["isEnd"]) {
            if(candidates[idNum].includes(cur.data)) return;
            candidates[idNum].push(cur.data);
            return;
        } 
        
        const char = id.charAt(idx);
        
        if(char === '*') {
            for(const ch in cur.children) {
                getBannedCandidate(cur.children[ch],idx+1,idNum);
            }
            
            return;
        }
        
        if(!cur.children || !(cur.children.hasOwnProperty(char)) ) {
            return;
        } 
        
       getBannedCandidate(cur.children[char],idx+1,idNum);
        
    }
    
    const comb = (idx, table) => {
        if(idx === banned_id.length) {
            
            combSet.add([...table].sort().join(""));
            //console.log(table);
            return;
        }
        
        for(let i = 0;i<candidates[idx].length;i++) {
            const id = candidates[idx][i];
            if(table.has(id)) continue;
            table.add(id);
            comb(idx+1,table);
            table.delete(id);
        }
    }
    
    user_id.forEach((id)=>{
        insertUser(id);
    });
    
    banned_id.forEach((_,idx)=>{
       getBannedCandidate(root,0,idx); 
    });
    
    
    console.log(candidates);
    //console.log(root.children['f']);
    
    comb(0,new Set());
    
    answer = combSet.size;
    
    return answer;
}