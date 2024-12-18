const [T, ...input] = require("fs")
  .readFileSync("dev/stdin")
  .toString()
  .trim()
  .split("\n");

const [N, M] = T.split(" ").map(Number);
graph = Array.from({ length: 101 }, (_, i) => i);
for (const [x, y] of input.map((item) => item.split(" ").map(Number))) {
  graph[x] = y;
}

const queue = [[1, 0]];
const visited = Array(101).fill(false);
visited[1] = true;
idx = 0;

while (queue.length > idx) {
  const [cur, res] = queue[idx++];

  if (cur === 100) {
    console.log(res);
    return;
  }
  for (let dice = 1; dice <= 6; dice++) {
    let next = cur + dice;

    if (next > 100) continue;
    next = graph[next];

    if (!visited[next]) {
      visited[next] = true;
      queue.push([next, res + 1]);
    }
  }
}
