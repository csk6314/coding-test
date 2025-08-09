const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const inputs = fs.readFileSync(filePath).toString().split("\n");

const T = +inputs[0];
let reading = 1;

const dfs = (parent, current, adj) => {
    let sum = 0;

    for(const [child, w] of adj[current]) {
        if(child !== parent) {
            const subValue = dfs(current, child,adj);
            sum += Math.min(subValue,w);
        }
    }

    return (sum === 0) ? Number.MAX_VALUE : sum;
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

    console.log(dfs(0,1,adj));
}


