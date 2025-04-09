const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
1. 동전을 제한없이 사용해서, 주어진 금액을 만들 수 있는 경우의 수
2. 1차원 dp로 풀기
3. dp[i] = i원을 만들 수 있는 가장 작은 경우의 수
*/
function solution(input) {
  const [n, k] = input[0].split(" ").map(Number);
  const coins = input.slice(1).map(Number);
  const dp = new Array(k + 1).fill(Infinity);
  dp[0] = 0;
  for (const coin of coins) {
    for (let i = coin; i <= k; i++) {
      dp[i] = Math.min(dp[i], dp[i - coin] + 1);
    }
  }

  return dp[k] === Infinity ? -1 : dp[k];
}

console.log(solution(input));
