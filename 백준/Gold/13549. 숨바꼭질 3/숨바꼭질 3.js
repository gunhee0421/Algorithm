const [N, K] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

const visited = Array(100001).fill(0);
let queue = [[N, 0]];
visited[N] = 1;

while (queue.length > 0) {
  const [position, time] = queue.shift();

  if (position === K) {
    console.log(time);
    break;
  }

  if (position > K) {
    if (!visited[position - 1]) {
      visited[position - 1] = 1;
      queue.push([position - 1, time + 1]);
    }
    continue;
  }

  for (const next of [position * 2, position - 1, position + 1]) {
    if (!visited[next] && next >= 0 && next <= K * 2) {
      visited[next] = 1;
      if (next === position * 2) {
        queue.unshift([next, time]);
      } else {
        queue.push([next, time + 1]);
      }
    }
  }
}
