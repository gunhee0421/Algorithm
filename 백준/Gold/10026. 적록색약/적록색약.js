const [T, ...input] = require("fs")
  .readFileSync("dev/stdin")
  .toString()
  .trim()
  .split("\n");

N = parseInt(T);
normalArray = input.map((line) => line.split(""));
redGreenArray = input.map((line) =>
  line.split("").map((v) => (v === "G" ? "R" : v))
);
normalVisited = Array.from({ length: N }, () => Array(N).fill(false));
redGreenVisited = Array.from({ length: N }, () => Array(N).fill(false));
res = [0, 0];
const direction = [
  [0, 1],
  [0, -1],
  [1, 0],
  [-1, 0],
];

const dfs = (array, visited, x, y) => {
  visited[x][y] = true;
  const color = array[x][y];

  for (const [dx, dy] of direction) {
    const nx = x + dx;
    const ny = y + dy;

    if (
      nx >= 0 &&
      nx < N &&
      ny >= 0 &&
      ny < N &&
      !visited[nx][ny] &&
      array[nx][ny] === color
    ) {
      dfs(array, visited, nx, ny);
    }
  }
};

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (!normalVisited[i][j]) {
      dfs(normalArray, normalVisited, i, j);
      res[0] += 1;
    }
    if (!redGreenVisited[i][j]) {
      dfs(redGreenArray, redGreenVisited, i, j);
      res[1] += 1;
    }
  }
}

console.log(res.join(" "));
