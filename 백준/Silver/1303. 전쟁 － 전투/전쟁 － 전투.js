const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
1. 상하좌우에 같이 있으면 "인접" n^2의 힘
2. 그래프 탐색 필요, 방문 지점은 통과
 */
function solution(input) {
  const [N, M] = input[0].split(" ").map(Number);
  const board = input.slice(1).map((line) => line.split(""));

  const visited = Array.from({ length: M }, () => Array(N).fill(false));
  const res = [0, 0];
  const directions = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];

  for (let i = 0; i < M; i++) {
    for (let j = 0; j < N; j++) {
      if (!visited[i][j]) {
        const team = board[i][j];
        const cnt = dfs(i, j, visited);
        if (team === "W") {
          res[0] += cnt * cnt;
        } else {
          res[1] += cnt * cnt;
        }
      }
    }
  }

  return res.join(" ");

  function dfs(x, y, visited) {
    let count = 1;
    visited[x][y] = true;

    for (const [dx, dy] of directions) {
      const nx = x + dx;
      const ny = y + dy;

      if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
      if (visited[nx][ny]) continue;
      if (board[nx][ny] !== board[x][y]) continue;

      count += dfs(nx, ny, visited);
    }
    return count;
  }
}

console.log(solution(input));
