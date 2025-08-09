const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const inputs = fs.readFileSync(filePath).toString().split("\n");

const T = +inputs[0];
let reading = 1;

const dfs = (parent, current, dp,adj) => {
    let sum = 0;

    for(const [child, w] of adj[current]) {
        if(child !== parent) {
            dfs(current, child,dp,adj);
            sum += Math.min(dp[child],w);
        }
    }

    dp[current] = sum > 0 ? sum : dp[current];
}

for(let t = 0;t<T;t++) {
    const [N, M] = inputs[reading++].split(" ").map((v)=>+v);
    
    if(N === 1) {
        console.log(0);
        continue;
    }

    const adj = Array.from({length:N+1},()=>[]);

    for(let b = 0;b<M;b++) {
        const [src, target, w] = inputs[reading++].split(" ").map((v)=>+v);
        adj[src].push([target, w]);
        adj[target].push([src,w]);
    }
    const dp = new Array(N+1).fill(Number.MAX_VALUE);
    dfs(0,1,dp,adj);

    console.log(dp[1]);
}


