const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
1. 퀸은 가로, 세로, 대각선으로 이동할 수 있다. -> 가로, 세로, 대각선에 있는 퀸을 체크해야함.
2. row별 놓을 수 있는 퀸의 개수를 카운트
*/
function solution(input) {
  const N = Number(input[0]);
  const board = Array.from({ length: N }, () => Array(N).fill(0));

  let res = 0;

  dfs(0);

  return res;

  function dfs(row) {
    if (row === N) {
      res++;
      return;
    }
    for (let col = 0; col < N; col++) {
      if (isValid(row, col)) {
        board[row][col] = 1;
        dfs(row + 1);
        board[row][col] = 0;
      }
    }
  }
  function isValid(row, col) {
    for (let i = 0; i < row; i++) {
      if (board[i][col] === 1) return false;
      if (col - (row - i) >= 0 && board[i][col - (row - i)] === 1) return false;
      if (col + (row - i) < N && board[i][col + (row - i)] === 1) return false;
    }
    return true;
  }
}

console.log(solution(input));
