const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
 */
function solution(input) {
  const words = input[0].split("");

  for (let i = 0; i <= Math.sqrt(words.length) + 1; i++) {
    const [a, b] = [words[i], words[words.length - i - 1]];

    if (a !== b) return 0;
  }
  return 1;
}

console.log(solution(input));
