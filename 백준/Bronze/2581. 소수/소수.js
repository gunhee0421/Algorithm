const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
1. 소수 판별 
*/
function solution(input) {
  const [M, N] = input.map(Number);

  const prime = [];

  for (let i = M; i <= N; i++) {
    if (isPrime(i)) {
      prime.push(i);
    }
  }

  return prime.length === 0
    ? -1
    : prime.reduce((acc, cur) => acc + cur, 0) + "\n" + prime[0];

  function isPrime(num) {
    if (num < 2) return false;
    for (let i = 2; i <= Math.sqrt(num); i++) {
      if (num % i === 0) return false;
    }
    return true;
  }
}

console.log(solution(input));
