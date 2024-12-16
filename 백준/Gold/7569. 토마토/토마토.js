const [T, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
const [M, N, H] = T.split(" ").map(Number);
const boxes = [];
let queue = [];
let count = 0;

for (let h = 0; h < H; h++) {
  const layer = input.slice(h * N, h * N + N).map((row, y) =>
    row.split(" ").map((ceil, x) => {
      const num = Number(ceil);
      if (num === 1) queue.push([x, y, h, 0]);
      if (num === 0) count++;
      return num;
    })
  );
  boxes.push(layer);
}
const direction = [
  [0, 0, 1],
  [0, 0, -1],
  [0, 1, 0],
  [0, -1, 0],
  [1, 0, 0],
  [-1, 0, 0],
];

let maxDays = 0;

if (count === 0) {
  console.log(0);
  return;
}

idx = 0;

while (queue.length > idx) {
  const [x, y, z, days] = queue[idx++];
  maxDays = Math.max(maxDays, days);

  for (const [dx, dy, dz] of direction) {
    const nx = x + dx;
    const ny = y + dy;
    const nz = z + dz;

    if (
      nx >= 0 &&
      nx < M &&
      ny >= 0 &&
      ny < N &&
      nz >= 0 &&
      nz < H &&
      boxes[nz][ny][nx] === 0
    ) {
      boxes[nz][ny][nx] = 1;
      count--;
      queue.push([nx, ny, nz, days + 1]);
    }
  }
}
console.log(count ? -1 : maxDays);
