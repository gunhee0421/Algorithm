const [order, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const [N, M] = order.split(" ").map(Number);
const home = [];
const chicken = [];
input.map((row, i) => {
  const numbers = row.split(" ").map(Number);
  numbers.forEach((num, j) => {
    if (num === 1) {
      home.push([i, j]);
    }
    if (num === 2) {
      chicken.push([i, j]);
    }
  });
  return numbers;
});

// 조합 추출 함수
function combination(arr, n) {
  let result = [];
  function dfs(current, idx) {
    if (current.length === n) {
      result.push([...current]);
      return;
    }
    for (let i = idx; i < arr.length; i++) {
      current.push(arr[i]);
      dfs(current, i + 1);
      current.pop();
    }
  }
  dfs([], 0);
  return result;
}

const combinationList = combination(chicken, M);
let city = Infinity;

while (combinationList.length > 0) {
  const curCombination = combinationList.pop();
  let res = 0;

  for (let i = 0; i < home.length; i++) {
    const distances = curCombination.map(
      (chicken) =>
        Math.abs(home[i][0] - chicken[0]) + Math.abs(home[i][1] - chicken[1])
    );
    res += Math.min(...distances);
  }

  city = Math.min(city, res);
}

console.log(city);
