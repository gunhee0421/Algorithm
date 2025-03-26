const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

class Heap {
  constructor() {
    this.heap = [null];
  }

  push(value) {
    this.heap.push(value);
    let cur = this.heap.length - 1;
    let par = Math.floor(cur / 2);

    while (cur > 1 && this.heap[par][1] > this.heap[cur][1]) {
      this.swap(par, cur);
      cur = par;
      par = Math.floor(cur / 2);
    }
  }

  pop() {
    if (this.heap.length <= 2) return this.heap.pop();
    const min = this.heap[1];
    this.heap[1] = this.heap.pop();

    let cur = 1;
    while (true) {
      let left = cur * 2;
      let right = cur * 2 + 1;
      let smallest = cur;

      if (
        left < this.heap.length &&
        this.heap[left][1] < this.heap[smallest][1]
      ) {
        smallest = left;
      }

      if (
        right < this.heap.length &&
        this.heap[right][1] < this.heap[smallest][1]
      ) {
        smallest = right;
      }

      if (smallest === cur) break;
      this.swap(cur, smallest);
      cur = smallest;
    }

    return min;
  }

  size() {
    return this.heap.length - 1;
  }

  swap(a, b) {
    [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
  }
}

function solution(input) {
  const [V, E] = input[0].split(" ").map(Number);
  const K = Number(input[1]);
  const graph = Array.from({ length: V + 1 }, () => []);

  for (let i = 0; i < E; i++) {
    const [x, y, w] = input[i + 2].split(" ").map(Number);
    graph[x].push([y, w]);
  }

  function dijkstra(start) {
    const distance = Array(V + 1).fill(Infinity);
    const visited = Array(V + 1).fill(false);
    distance[start] = 0;

    const heap = new Heap();
    heap.push([start, 0]);

    while (heap.size() > 0) {
      const [node, dist] = heap.pop();

      if (visited[node]) continue;
      visited[node] = true;

      for (const [next, weight] of graph[node]) {
        if (distance[next] > dist + weight) {
          distance[next] = dist + weight;
          heap.push([next, distance[next]]);
        }
      }
    }
    return distance;
  }

  const distance = dijkstra(K);
  const result = distance
    .slice(1)
    .map((data) => (data !== Infinity ? data : "INF"))
    .join("\n");

  return result;
}

console.log(solution(input));
