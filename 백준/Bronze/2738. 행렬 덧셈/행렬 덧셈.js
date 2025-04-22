const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
 */
function solution(input) {
  const [N, M] = input[0].split(" ").map(Number);
  const graph1 = input
    .slice(1, N + 1)
    .map((line) => line.split(" ").map(Number));
  const graph2 = input.slice(N + 1).map((line) => line.split(" ").map(Number));

  const res = [];

  for (let i = 0; i < N; i++) {
    const line = [];
    for (let j = 0; j < M; j++) {
      line.push(graph1[i][j] + graph2[i][j]);
    }
    res.push(line);
  }
  return res.map((line) => line.join(" ")).join("\n");
}

console.log(solution(input));
