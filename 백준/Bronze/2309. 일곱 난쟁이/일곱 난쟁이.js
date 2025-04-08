const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  const number = input.map(Number);
  const totalSum = number.reduce((a, b) => a + b, 0);
  let found = false;
  let res = "";

  for (let i = 0; i < 9; i++) {
    for (let j = i + 1; j < 9; j++) {
      if (totalSum - input[i] - input[j] === 100) {
        const result = input
          .filter((_, idx) => idx !== i && idx !== j)
          .sort((a, b) => a - b);
        res = result.join("\n");
        found = true;
        break;
      }
    }
    if (found) break;
  }
  return res;
}

console.log(solution(input));
