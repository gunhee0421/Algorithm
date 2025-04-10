const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
1. 배열 sort후 마지막 length - 3의 결과 출력
*/
function solution(input) {
  const T = Number(input[0]);
  const res = [];
  for (let i = 0; i < T; i++) {
    const arr = input[i + 1].split(" ").map(Number);
    arr.sort((a, b) => a - b);
    res.push(arr[arr.length - 3]);
  }
  return res.join("\n");
}

console.log(solution(input));
