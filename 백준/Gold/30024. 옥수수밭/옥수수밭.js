const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const inputs = fs.readFileSync(filePath).toString().split("\n");

class PriorityQueue {
    #compare = (a,b) => a < b;
    #heap = [];

    constructor(comparator) {
        if(comparator) {
            this.#compare = comparator;
        }
    }

    push(value) {
        const heap = this.#heap;
        heap.push(value);

        let idx = heap.length - 1;
        while(idx > 0) {
            const parent = Math.floor((idx-1)/2);
            if(this.#compare(heap[idx],heap[parent])) {
                [heap[idx],heap[parent]] = [heap[parent],heap[idx]];
                idx = parent;
                continue;
            }
            break;
        }

    }

    heapify(idx) {
        const heap = this.#heap;
        const n = heap.length;

        while(true) {
            let current = idx;
            const left = idx * 2 + 1;
            const right = idx * 2 + 2;

            if(left < n && this.#compare(heap[left],heap[current])) current = left;
            if(right < n && this.#compare(heap[right],heap[current])) current = right;
            if(current === idx) break;

            [heap[current],heap[idx]] = [heap[idx],heap[current]];
            idx = current;

        }
    }

    shift() {
        const heap = this.#heap;

        if(heap.length <= 0) return;
        if(heap.length === 1) {
            return heap.pop();
        }

        const top = heap[0];
        const last = heap.pop();
        heap[0] = last;
        this.heapify(0);

        return top;
    }
    
    isEmpty() {
        return this.#heap.length === 0;
    }

    test() {
        return this.#heap;
    }

}

const [N,M] = inputs[0].split(" ").map((v)=>+v);
const field = Array.from({length:N+2},()=>new Array(M+2).fill(0));
const K = +inputs[N+1];

for(let r = 1;r<=N;r++) {
    const row = inputs[r].split(" ");
    for(let c = 1;c<=M;c++) {
        field[r][c] = +row[c-1];
    }
}

const dr = [1,0,-1,0];
const dc = [0,1,0,-1];
const pq = new PriorityQueue((a,b)=>a[2] > b[2]);
const visited = Array.from({length:N+2},()=>new Array(M+2).fill(false));

for(let r = 0;r<N+2;r++) {
    for(let c = 0;c<M+2;c++) {
        if(field[r][c] !== 0) continue;
        for(let i = 0;i<4;i++) {
            const nr = r + dr[i];
            const nc = c + dc[i];
            if(nr < 0 || nr >= N+2 || nc < 0 || nc >= M+2) continue;
            if(!visited[nr][nc] && field[nr][nc] !== 0) {
                pq.push([nr,nc,field[nr][nc]]);
                visited[nr][nc] = true;
            }

        }
    }
}
//console.table(pq.test());
let k = 0;
let ans = [];

while(!pq.isEmpty() && k < K) {
    const [r,c,v] = pq.shift();
    k++;
    ans.push(r + " " + c);
    for(let i = 0;i<4;i++) {
        const nr = r + dr[i];
        const nc = c + dc[i];
        if(nr < 0 || nr >= N+2 || nc < 0 || nc >= M+2) continue;
        if(!visited[nr][nc] && field[nr][nc] !== 0) {
            pq.push([nr,nc,field[nr][nc]]);
            visited[nr][nc] = true;
        }
    }

}
//console.table(field);
console.log(ans.join("\n"));

