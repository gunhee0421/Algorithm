const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
1. 오른쪽, 아래 두방향으로만 점프가 가능하며, 점프를 통해 오른쪽 하단 끝까지 도차 가능한 경우의 수 구하기
2. 2차원 dp로 각 칸에 도달하는 경우의 수를 저장
*/
function solution(input) {
  const N = Number(input[0]);
  const graph = input.slice(1).map((line) => line.split(" ").map(Number));
  const dp = Array.from({ length: N + 1 }, () => Array(N + 1).fill(BigInt(0)));

  dp[1][1] = 1;

  for (let i = 1; i < N + 1; i++) {
    for (let j = 1; j < N + 1; j++) {
      const jump = graph[i - 1][j - 1];
      if (dp[i][j] === 0 || jump === 0) continue;

      // right
      if (j + jump < N + 1) {
        dp[i][j + jump] += BigInt(dp[i][j]);
      }
      // down
      if (i + jump < N + 1) {
        dp[i + jump][j] += BigInt(dp[i][j]);
      }
    }
  }

  return dp[N][N].toString();
}

console.log(solution(input));
