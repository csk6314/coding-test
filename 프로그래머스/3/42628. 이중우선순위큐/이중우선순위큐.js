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

        let idx = heap.length -1;
        while(idx>0) {
            const parent = Math.floor((idx-1)/2);
            if(this.#compare(heap[idx], heap[parent])) {
                //console.log(heap[idx],heap[parent]);
                [heap[idx],heap[parent]] = [heap[parent],heap[idx]];
                idx = parent;
                continue;
            }
            break;
        }

    }

    heapify(idx) {
        const heap = this.#heap;
        const n = this.#heap.length;

        while(true) {
            let smallest = idx;
            const left = idx*2 + 1;
            const right = idx*2 + 2;

            if(left < n && this.#compare(heap[left],heap[smallest])) smallest = left;
            if(right < n && this.#compare(heap[right],heap[smallest])) smallest = right;

            if(smallest === idx) break;

            [heap[idx],heap[smallest]] = [heap[smallest],heap[idx]];
            idx = smallest;
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

    remove(target) {
        const heap =this.#heap;
        const idx = heap.indexOf(target);

        if(idx === -1) return;

        const last = heap.pop();
        if(heap.length === 0 || idx >= heap.length) return;

        heap[idx] = last;
        this.heapify(idx);
    }
    
    isEmpty() {
        return this.#heap.length === 0 ? true : false;
    }

    toString() {
        return this.#heap.toString();
    }

}

function solution(operations) {
    var answer = [];
    
    const minQ = new PriorityQueue();
    const maxQ = new PriorityQueue((a,b) => a>b);
    
    operations.forEach((op)=>{
        const [command, val] = op.split(" ").map((v)=>isNaN(Number(v)) ? v : +v);
      //console.log(minQ.toString(), maxQ.toString());
        if(command === "I") {
            minQ.push(val);
            maxQ.push(val);
            return;
        }
        
        if(command === "D") {
            if(val === -1) {
                if(minQ.isEmpty()) return;
                const min = minQ.shift();
                maxQ.remove(min);
                return;
            }
            
            if(val=== 1) {
                if(maxQ.isEmpty()) return;
                const max = maxQ.shift();
                minQ.remove(max);
                return;
            }
        }
    })
    
    if(maxQ.isEmpty() && minQ.isEmpty()) {
        return [0,0];
    }
    
    return [maxQ.shift(),minQ.shift()];
}