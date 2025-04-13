const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
1. N높이의 삼각형으로 별찍기
2. N이 3이되면 동일한 삼각형이 그려지도록
*/
function solution(input) {
  const N = Number(input[0]);
  const graph = Array.from({ length: N }, () => Array(2 * N - 1).fill(" "));

  function draw(x, y, n) {
    if (n === 3) {
      graph[x][y] = "*";
      graph[x + 1][y - 1] = "*";
      graph[x + 1][y + 1] = "*";
      for (let i = -2; i <= 2; i++) {
        graph[x + 2][y - i] = "*";
      }
      return;
    }

    const half = n / 2;
    draw(x, y, half);
    draw(x + half, y - half, half);
    draw(x + half, y + half, half);
  }
  draw(0, N - 1, N);

  return graph.map((row) => row.join("")).join("\n");
}

console.log(solution(input));
