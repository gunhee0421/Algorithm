const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  const [N, M, K] = input[0].split(" ").map(Number);
  const graph = Array.from({ length: N }, () => Array(M).fill(0));
  const visited = Array.from({ length: N }, () => Array(M).fill(false));

  for (let i = 1; i <= K; i++) {
    const [x, y] = input[i].split(" ").map(Number);
    graph[x - 1][y - 1] = 1;
  }

  const dx = [0, 0, 1, -1];
  const dy = [1, -1, 0, 0];

  function dfs(x, y) {
    let count = 1;
    visited[x][y] = true;

    for (let dir = 0; dir < 4; dir++) {
      const nx = x + dx[dir];
      const ny = y + dy[dir];

      if (
        nx >= 0 &&
        ny >= 0 &&
        nx < N &&
        ny < M &&
        !visited[nx][ny] &&
        graph[nx][ny] === 1
      ) {
        count += dfs(nx, ny);
      }
    }

    return count;
  }

  let maxSize = 0;

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (graph[i][j] === 1 && !visited[i][j]) {
        maxSize = Math.max(maxSize, dfs(i, j));
      }
    }
  }

  return maxSize;
}

console.log(solution(input));
