const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
1. 연산자 우선순위 무시 -> 그냥 순서대로 계산
2. 숫자의 위치 변경 불가능, 무조건 순서대로
3. /의 경우 나머지 버림, 몫만 취함
4. 음수는 가능

------

1. dp ? : 경우의 수가 너무 많음
2. 완전탐색: 가능 / N <= 11 && A[i] <= 100 => 11^2 + 100^2 <= 2억 미만. 시간초과는 안날듯?
*/
function solution(input) {
  const N = Number(input[0]);
  const number = input[1].split(" ").map(Number);
  const method = input[2].split(" ").map(Number);

  let maxRes = -Infinity;
  let minRes = Infinity;

  function dfs(index, current, plus, minus, mul, div) {
    if (index === N) {
      maxRes = Math.max(maxRes, current);
      minRes = Math.min(minRes, current);
      return;
    }
    if (plus > 0) {
      dfs(index + 1, current + number[index], plus - 1, minus, mul, div);
    }
    if (minus > 0) {
      dfs(index + 1, current - number[index], plus, minus - 1, mul, div);
    }
    if (mul > 0) {
      dfs(index + 1, current * number[index], plus, minus, mul - 1, div);
    }
    if (div > 0) {
      const next =
        current < 0
          ? -Math.floor(-current / number[index])
          : Math.floor(current / number[index]);
      dfs(index + 1, next, plus, minus, mul, div - 1);
    }
  }
  dfs(1, number[0], method[0], method[1], method[2], method[3]);
  return `${maxRes}\n${minRes}`;
}

console.log(solution(input));
