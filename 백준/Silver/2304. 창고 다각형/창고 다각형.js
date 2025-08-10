const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const inputs = fs.readFileSync(filePath).toString().split("\n");

let reading = 0;

const N = +inputs[reading++];
const pillars = [];
for(let i  =0;i<N;i++) {
    pillars.push(inputs[reading++].split(" ").map((v)=>+v));
}

pillars.sort((a,b)=>a[0]-b[0]);

const stack = [];
let sum = 0;

for(let i = 0;i<pillars.length;i++) {

    if(stack.length === 0) {
        stack.push(pillars[i]);
        continue;
    }

    if(pillars[i][1] >= stack[stack.length-1][1]) {
        stack.push(pillars[i]);
    }

}

const hmax = stack[stack.length-1][1];
let left = 1001;
let right = -1;

while(stack.length > 0) {
    const [x,h] = stack.pop();
    if(h === hmax) {
        left = Math.min(x,left);
        right = Math.max(x+1, right);
    }
    
    if(stack.length > 0 ) {
        const [nx,nh] = stack[stack.length-1];

        if(nh !== hmax) {
            sum += nh * (x-nx);
        }
    }

}

sum += (right-left) * hmax;


let ph = -1;
let px = -1;
for(let i = pillars.length - 1;i>=0;i--) {
    const [x,h] = pillars[i];
    if(x < right - 1) break;
    if(ph === -1 || px === -1) {
        ph = h;
        px = x;
        continue;
    }
    if(h > ph) {
        sum += (px - x) * ph;
        ph = h;
        px = x;
    }


}


console.log(sum);