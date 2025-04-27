const { log } = require("console");

const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  const [N, M] = input[0].split(" ").map(Number);
  const arr = Array(N)
    .fill(1)
    .map((a, b) => a + b);

  for (let i = 1; i <= M; i++) {
    let [x, y] = input[i].split(" ").map(Number);
    let tmp = arr[x - 1];
    arr[x - 1] = arr[y - 1];
    arr[y - 1] = tmp;
  }

  console.log(arr.join(" "));
}

solution(input);
