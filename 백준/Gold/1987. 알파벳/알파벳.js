const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
1. set으로 중복 검사 후 패스
2. dfs로 깊이탐색
*/
function solution(input) {
  const [R, C] = input[0].split(" ").map(Number);
  const board = input.slice(1).map((row) => row.split(""));
  const visited = new Set();
  const directions = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
  ];
  let res = 0;

  dfs(0, 0, 1);

  return res;

  function dfs(x, y, count) {
    visited.add(board[x][y]);
    res = Math.max(res, count);

    for (const [dx, dy] of directions) {
      const nx = x + dx;
      const ny = y + dy;

      if (
        nx >= 0 &&
        nx < R &&
        ny >= 0 &&
        ny < C &&
        !visited.has(board[nx][ny])
      ) {
        dfs(nx, ny, count + 1);
      }
    }
    visited.delete(board[x][y]);
  }
}

console.log(solution(input));
