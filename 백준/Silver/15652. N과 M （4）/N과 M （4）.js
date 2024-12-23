const [N, M] = require("fs")
  .readFileSync("dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

const Combination = (N, M) => {
  const res = [];
  const combination = [];

  const backtracking = (start) => {
    if (combination.length === M) {
      res.push([...combination]);
      return;
    }
    for (let i = start; i <= N; i++) {
      combination.push(i);
      backtracking(i);
      combination.pop();
    }
  };
  backtracking(1);
  return res;
};

const result = Combination(N, M);
console.log(result.map((t) => t.join(" ")).join("\n"));
