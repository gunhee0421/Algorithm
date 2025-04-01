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

  function dfs(index, current, operators) {
    if (index === N) {
      maxRes = Math.max(maxRes, current);
      minRes = Math.min(minRes, current);
      return;
    }

    for (let i = 0; i < 4; i++) {
      if (operators[i] > 0) {
        const newOperators = [...operators];
        newOperators[i]--;

        let next;
        if (i === 0) next = current + number[index];
        else if (i === 1) next = current - number[index];
        else if (i === 2) next = current * number[index];
        else {
          next =
            current < 0
              ? -Math.floor(Math.abs(current) / number[index])
              : Math.floor(current / number[index]);
        }

        dfs(index + 1, next, newOperators);
      }
    }
  }
  dfs(1, number[0], method);
  return `${maxRes}\n${minRes}`;
}

console.log(solution(input));
