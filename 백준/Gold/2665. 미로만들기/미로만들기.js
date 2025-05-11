"use strict";
const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const input = fs.readFileSync(filePath).toString().split('\n');

const n = +input[0];

const map = input.slice(1).map((row)=>row.split("").map((v)=>+v));
const cost = map.map(()=>new Array(n).fill(Number.MAX_VALUE));
const visited = map.map(()=>new Array(n).fill(false));
const dr = [1,0,-1,0];
const dc = [0,1,0,-1];

const findLowCost = () => {
    let minIdx = [0,0];
    let minCost = Number.MAX_VALUE;

    for(let i = 0;i<n;i++) {
        for(let j = 0;j<n;j++) {
            if(visited[i][j]) continue;
            if(minCost > cost[i][j]) {
                minIdx = [i,j];
                minCost = cost[i][j];
            }
        }
    }

    return minIdx;
}

const findPath = (startPos) => {
    const [r,c] = startPos;
    cost[r][c] = 0;

    for(let i = 0;i<n;i++) {
        for(let j = 0;j<n;j++) {
            const [mr,mc] = findLowCost();

            visited[mr][mc] = true;

            for(let k = 0;k<4;k++) {
                const nr = dr[k] + mr;
                const nc = dc[k] + mc;

                if(nc < 0 || nc >= n || nr < 0 || nr >= n) continue;
                const newCost = (map[nr][nc]===1 ? 0 : 1) + cost[mr][mc];

                if(newCost < cost[nr][nc]) {
                    cost[nr][nc] = newCost;
                }
                
            }
        }
    }
}

findPath([0,0]);
console.log(cost[n-1][n-1]);




//console.log(map);