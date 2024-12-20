const [T, ...input] = require("fs")
  .readFileSync("dev/stdin")
  .toString()
  .trim()
  .split("\n");

graph = input.map((v) => v.split(" ").map(Number));
result = [];

for (let i = 0; i < graph.length; i++) {
  const [start, end] = graph[i];

  const queue = [[start, ""]];
  const visited = Array(10000).fill(false);
  visited[start] = true;
  let idx = 0;

  while (queue.length > idx) {
    const [cur, commands] = queue[idx++];

    if (cur === end) {
      result.push(commands);
      break;
    }
    const D = (cur * 2) % 10000;
    if (!visited[D]) {
      visited[D] = true;
      queue.push([D, commands + "D"]);
    }
    const S = cur === 0 ? 9999 : cur - 1;
    if (!visited[S]) {
      visited[S] = true;
      queue.push([S, commands + "S"]);
    }
    const L = parseInt((cur % 1000) * 10 + Math.floor(cur / 1000));
    if (!visited[L]) {
      visited[L] = true;
      queue.push([L, commands + "L"]);
    }
    const R = parseInt((cur % 10) * 1000 + Math.floor(cur / 10));
    if (!visited[R]) {
      visited[R] = true;
      queue.push([R, commands + "R"]);
    }
  }
}

console.log(result.join("\n"));
