const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
1. board의 최대 좌우/상하 길이를 구한다.
2. 완전탐색으로 모든 좌우/상하 교체시의 길이를 비교한다.
*/
function getMaxLength(board) {
  let maxLength = 0;
  const N = board.length;

  for (let i = 0; i < N; i++) {
    let rowLength = 1;
    let colLength = 1;
    for (let j = 1; j < N; j++) {
      if (board[i][j] === board[i][j - 1]) {
        rowLength++;
      } else {
        maxLength = Math.max(maxLength, rowLength);
        rowLength = 1;
      }
      if (board[j][i] === board[j - 1][i]) {
        colLength++;
      } else {
        maxLength = Math.max(maxLength, colLength);
        colLength = 1;
      }
    }
    maxLength = Math.max(maxLength, rowLength, colLength);
  }
  return maxLength;
}

function solution(input) {
  const N = Number(input[0]);
  const arr = input.slice(1).map((line) => line.split(""));

  let res = 0;

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      let origin = arr[i][j];

      // swap row
      if (j + 1 < N) {
        [arr[i][j], arr[i][j + 1]] = [arr[i][j + 1], arr[i][j]];
        res = Math.max(res, getMaxLength(arr));
        [arr[i][j], arr[i][j + 1]] = [arr[i][j + 1], arr[i][j]];
      }

      // swap col
      if (i + 1 < N) {
        [arr[i][j], arr[i + 1][j]] = [arr[i + 1][j], arr[i][j]];
        res = Math.max(res, getMaxLength(arr));
        [arr[i][j], arr[i + 1][j]] = [arr[i + 1][j], arr[i][j]];
      }
    }
  }

  if (res === N) {
    return res;
  }

  return res;
}

console.log(solution(input));
