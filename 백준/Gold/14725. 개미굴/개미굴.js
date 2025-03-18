"use strict";
const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const inputs = fs.readFileSync(filePath).toString().trim().split("\n");

const N = +inputs[0];
const feedInfo = inputs.slice(1).map((row) => {
  const v = row.split(" ");
  v[0] = +v[0];

  return v;
});


const init = () => {
  const root = {
    children: {},
  };

  feedInfo.forEach((feed) => {
    let n = 0;
    let cur = root;
    while (++n <= feed[0]) {
      if (!cur.children[feed[n]]) {
        cur.children[feed[n]] = {
          children: {},
        };
      }

      cur = cur.children[feed[n]];
    }
  });

  printResult(root, 0);
};

const printResult = (obj, dep) => {
  for (const key of Object.keys(obj.children).sort()) {
    console.log("--".repeat(dep) + key);
    printResult(obj.children[key], dep + 1);
  }
};

init();
