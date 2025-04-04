const filePath = process.platform === 'linux' ? '/dev/stdin' : 'input.txt';
const input = require('fs').readFileSync(filePath).toString().split('\n');

function solution(input) {
  const arr = input.slice(0, 10).map((el) => el.split(' ').map(Number));

  let res = 0;
  let cur = 0;
  for (let i = 0; i < arr.length; i++) {
    const [a, b] = arr[i];

    cur -= a;
    cur += b;
    res = Math.max(res, cur);
  }
  return res;
}

console.log(solution(input));
