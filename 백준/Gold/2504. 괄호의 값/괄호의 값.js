const filePath = process.platform === 'linux' ? '/dev/stdin' : 'input.txt';
const input = require('fs').readFileSync(filePath).toString().trim();

function solution(input) {
  const stack = [];
  for (let i = 0; i < input.length; i++) {
    const char = input[i];
    if (char === '(' || char === '[') {
      stack.push(char);
    } else {
      let temp = 0;
      let matched = false;
      while (stack.length) {
        const top = stack.pop();
        if (typeof top === 'number') {
          temp += top;
        } else {
          if ((char === ')' && top === '(') || (char === ']' && top === '[')) {
            if (temp === 0) {
              stack.push(char === ')' ? 2 : 3);
            } else {
              stack.push((char === ')' ? 2 : 3) * temp);
            }
            matched = true;
            break;
          } else {
            return 0;
          }
        }
      }
      if (!matched) {
        return 0;
      }
    }
  }
  let res = 0;
  for (const val of stack) {
    if (typeof val === 'number') {
      res += val;
    } else {
      return 0;
    }
  }
  return res;
}

console.log(solution(input));
