const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
1. 임의의 정점에서 가장 먼 노드 탐색.
2. 1에서 찾은 노드에서 가장 먼 노드 탐색.
*/
function solution(input) {
  const n = Number(input[0]);
  const graph = Array.from({ length: n + 1 }, () => []);

  input.slice(1).forEach((line) => {
    const [from, to, weight] = line.split(" ").map(Number);
    graph[from].push({ to, weight });
    graph[to].push({ to: from, weight });
  });

  const [_, farthestNode] = dfs(1, Array(n + 1).fill(false), graph);
  const [diameter] = dfs(farthestNode, Array(n + 1).fill(false), graph);
  return diameter;

  function dfs(node, visited, graph) {
    visited[node] = true;
    let maxDistance = 0;
    let farthestNode = node;

    for (const { to, weight } of graph[node]) {
      if (!visited[to]) {
        const [distance, farthest] = dfs(to, visited, graph);
        if (distance + weight > maxDistance) {
          maxDistance = distance + weight;
          farthestNode = farthest;
        }
      }
    }
    return [maxDistance, farthestNode];
  }
}

console.log(solution(input));
