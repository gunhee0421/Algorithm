const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  const n = Number(input[0]);

  function dfs(start) {
    if (start === 0) {
      return 0;
    } else if (start === 1) {
      return 1;
    } else {
      return dfs(start - 1) + dfs(start - 2);
    }
  }
  return dfs(n);
}

console.log(solution(input));
