const [order, input] = require("fs")
  .readFileSync("dev/stdin")
  .toString()
  .trim()
  .split("\n");

const [N, M] = order.split(" ").map(Number);
const arr = input
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);

const Combination = (N, M) => {
  const res = [];
  const combination = [];
  const visited = Array(N).fill(false);

  const backtracking = (start) => {
    if (combination.length === M) {
      res.push([...combination]);
      return;
    }
    for (let i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        combination.push(arr[i]);
        backtracking(i + 1);
        combination.pop();
        visited[i] = false;
      }
    }
  };
  backtracking(0);
  return res;
};

const result = Combination(N, M);
console.log(result.map((t) => t.join(" ")).join("\n"));
