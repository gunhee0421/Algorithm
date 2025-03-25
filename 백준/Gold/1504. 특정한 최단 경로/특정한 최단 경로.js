const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  const [N, E] = input[0].split(" ").map(Number);
  const graph = Array.from({ length: N + 1 }, () => []);

  for (let i = 1; i <= E; i++) {
    const [a, b, c] = input[i].split(" ").map(Number);
    graph[a].push([b, c]);
    graph[b].push([a, c]);
  }

  const [v1, v2] = input[E + 1].split(" ").map(Number);

  function dijkstra(start) {
    const dist = Array(N + 1).fill(Infinity);
    const pq = [[0, start]];
    dist[start] = 0;

    while (pq.length > 0) {
      pq.sort((a, b) => a[0] - b[0]);
      const [cost, now] = pq.shift();

      if (dist[now] < cost) continue;

      for (const [next, weight] of graph[now]) {
        const newCost = cost + weight;
        if (newCost < dist[next]) {
          dist[next] = newCost;
          pq.push([newCost, next]);
        }
      }
    }

    return dist;
  }

  const from1 = dijkstra(1);
  const fromV1 = dijkstra(v1);
  const fromV2 = dijkstra(v2);

  const path1 = from1[v1] + fromV1[v2] + fromV2[N];
  const path2 = from1[v2] + fromV2[v1] + fromV1[N];

  const answer = Math.min(path1, path2);

  return answer === Infinity ? -1 : answer;
}

console.log(solution(input));
