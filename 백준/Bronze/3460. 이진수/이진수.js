const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  const T = Number(input[0]);

  for (let i = 0; i < T; i++) {
    const N = Number(input[i + 1]);
    const bin = N.toString(2);
    const arr = [...bin];
    const len = arr.length;
    let res = "";
    for (let j = 0; j < len; j++) {
      let n = arr.pop();
      if (n === "1") {
        res += j + " ";
      }
    }
    console.log(res);
  }
}

solution(input);
