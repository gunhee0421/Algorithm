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
function getLineMaxLength(board, i, j) {
  const N = board.length;
  let max = 1;

  let row = 1;
  for (let k = 1; k < N; k++) {
    if (board[i][k] === board[i][k - 1]) {
      row++;
      max = Math.max(max, row);
    } else {
      row = 1;
    }
  }

  let col = 1;
  for (let k = 1; k < N; k++) {
    if (board[k][j] === board[k - 1][j]) {
      col++;
      max = Math.max(max, col);
    } else {
      col = 1;
    }
  }

  return max;
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
        res = Math.max(
          res,
          getLineMaxLength(arr, i, j),
          getLineMaxLength(arr, i, j + 1)
        );
        [arr[i][j], arr[i][j + 1]] = [arr[i][j + 1], arr[i][j]];
      }

      // swap col
      if (i + 1 < N) {
        [arr[i][j], arr[i + 1][j]] = [arr[i + 1][j], arr[i][j]];
        res = Math.max(
          res,
          getLineMaxLength(arr, i, j),
          getLineMaxLength(arr, i + 1, j)
        );
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
