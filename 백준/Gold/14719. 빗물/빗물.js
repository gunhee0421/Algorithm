const filePath = process.platform === 'linux' ? '/dev/stdin' : 'input.txt';
const input = require('fs')
  .readFileSync(filePath)
  .toString()
  .trim()
  .split('\n');

function solution(input) {
  const [H, W] = input[0].split(' ').map(Number);
  const block = input[1].split(' ').map(Number);

  let res = 0;

  for (let i = 0; i < W - 1; i++) {
    let leftMax = Math.max(...block.slice(0, i));
    let rightMax = Math.max(...block.slice(i + 1));

    let min = Math.min(leftMax, rightMax);

    if (block[i] < min) {
      res += min - block[i];
    }
  }
  return res;
}

console.log(solution(input));
