const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(filePath).toString().trim().split(" ");

/*
 */
function solution(input) {
  return parseInt(input[0], Number(input[1]));
}

console.log(solution(input));
