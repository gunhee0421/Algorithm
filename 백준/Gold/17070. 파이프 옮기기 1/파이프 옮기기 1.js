const [order, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// 0:가로 / 1:대각선 / 2:세로
const N = parseInt(order);
const graph = input.map((v) => v.split(" ").map(Number));
const dp = Array.from({ length: N }, () =>
  Array.from({ length: N }, () => Array(N).fill(0))
);

for (let i = 0; i < N; i++) {
  if (graph[0][i] === 1) break;
  dp[0][i][0] = 1;
}

for (let i = 1; i < N; i++) {
  for (let j = 2; j < N; j++) {
    if (graph[i][j] === 1) continue;
    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];

    if (graph[i - 1][j] === 0 && graph[i][j - 1] === 0) {
      dp[i][j][1] =
        dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
    }

    dp[i][j][2] = dp[i - 1][j][2] + dp[i - 1][j][1];
  }
}

const result = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
console.log(result);
