const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  const n = Number(input[0]);
  let dot = 2;

  for (let i = 0; i < n; i++) {
    dot += Math.pow(2, i);
  }
  return Math.pow(dot, 2);
}

console.log(solution(input));
