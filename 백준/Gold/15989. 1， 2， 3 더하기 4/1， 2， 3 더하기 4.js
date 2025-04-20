const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
1. n을 1,2,3의 합으로 나타내는 방법의 수를 구하는 문제 (순서의 다름은 동일로 취급)
2. dp를 사용해 각 n에 대해서 1, 2, 3을 더한 경우의 수를 저장
3. 1차원 dp로 실패 / 2차원 dp로 각 뒤에 1, 2, 3을 더한 경우를 저장
*/
function solution(input) {
  const T = Number(input[0]);
  const arr = input.slice(1).map(Number);
  const Max = Math.max(...arr);

  const dp = Array.from({ length: Max + 1 }, () => Array(4).fill(0));

  for (let i = 1; i <= 3; i++) {
    dp[0][i] = 1;
  }

  for (let i = 1; i <= Max; i++) {
    for (let j = 1; j <= 3; j++) {
      if (i - j >= 0) dp[i][j] += dp[i - j][j];
      dp[i][j] += dp[i][j - 1];
    }
  }

  const res = [];

  for (let i = 0; i < T; i++) {
    res.push(dp[arr[i]][3]);
  }
  return res.join("\n");
}

console.log(solution(input));
