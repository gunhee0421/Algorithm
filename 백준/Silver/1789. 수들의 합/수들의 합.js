const filePath = process.platform === 'linux' ? '/dev/stdin' : 'input.txt';
const input = require('fs').readFileSync(filePath).toString().split('\n');

function solution(input) {
  const S = BigInt(input[0]);

  let sum = 0;
  let i = 1;
  let count = 0;

  while (sum + i <= S) {
    sum += i;
    i += 1;
    count += 1;
  }
  return count;
}

console.log(solution(input));
