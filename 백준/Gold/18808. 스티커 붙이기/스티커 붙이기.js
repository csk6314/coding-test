"use strict";
const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const inputs = fs.readFileSync(filePath).toString().split("\n");

const [N, M, K] = inputs[0].split(" ").map((v) => +v);
const notebook = Array.from({ length: N }, () => new Array(M).fill(0));
const stickers = [];

for (let i = 0, cnt = 1; i < K; i++) {
  const [R, C] = inputs[cnt].split(" ").map((v) => +v);
  const sticker = inputs
    .slice(cnt + 1, cnt + R + 1)
    .map((row) => row.split(" ").map((v) => +v));
  cnt += R + 1;

  stickers.push(sticker);
}

//console.log(notebook);

const rotateSticker = (sticker) => {
  const r = sticker.length;
  const c = sticker[0].length;

  const rotated = Array.from({ length: c }, (_, rv) =>
    new Array(r).fill(0).map((_, cv) => sticker[r - (cv + 1)][rv])
  );

  return rotated;
};

const isAttached = (notebook, sticker, r, c) => {
  const rSize = sticker.length;
  const cSize = sticker[0].length;

  for (let i = r; i < r + rSize; i++) {
    for (let j = c; j < c + cSize; j++) {
      if (notebook[i][j] === 1 && sticker[i - r][j - c] === 1) {
        return false;
      }
    }
  }

  for (let i = r; i < r + rSize; i++) {
    for (let j = c; j < c + cSize; j++) {
      if (sticker[i - r][j - c] === 1) {
        notebook[i][j] = sticker[i - r][j - c];
      }
    }
  }

  return true;
};

const init = () => {
  while (stickers.length > 0) {
    let sticker = stickers.shift();

    let rSize = sticker.length;
    let cSize = sticker[0].length;

    let done = false;

    for (let rot = 0; rot < 4; rot++) {
      for (let i = 0; i < notebook.length - rSize + 1; i++) {
        for (let j = 0; j < notebook[0].length - cSize + 1; j++) {
          if (isAttached(notebook, sticker, i, j)) {
            //   console.log(sticker, i, j, rot);
            // console.log(notebook);
            done = true;
            break;
          }
        }
        if (done) break;
      }
      if (done) break;
      sticker = rotateSticker(sticker);
      rSize = sticker.length;
      cSize = sticker[0].length;
    }
  }

  printResult(notebook);
};

const printResult = (notebook) => {
  let cnt = 0;
  for (let i = 0; i < notebook.length; i++) {
    for (let j = 0; j < notebook[0].length; j++) {
      if (notebook[i][j] === 1) {
        cnt++;
      }
    }
  }

  console.log(cnt);
};

init();
