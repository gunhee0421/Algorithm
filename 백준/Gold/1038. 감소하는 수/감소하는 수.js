const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
1. 감소하는 수 = 가장 왼쪽 자리 수부터 오른쪽끝까지 계속 줄어드는 수
2. 0~9까지의 숫자 중에서 감소하는 수를 만들기
3. 오름차순 정렬
*/
function solution(input) {
  const N = Number(input[0]);

  const res = [];

  for (let i = 0; i < 10; i++) {
    backtrack(i, i);
  }

  res.sort((a, b) => a - b);

  if (N < res.length) {
    return res[N];
  } else {
    return -1;
  }

  function backtrack(cur, lastDigit) {
    res.push(cur);
    for (let i = 0; i < lastDigit; i++) {
      backtrack(cur * 10 + i, i);
    }
  }
}

console.log(solution(input));
