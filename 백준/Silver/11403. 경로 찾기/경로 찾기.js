const [T, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
const data = input.map((v) => v.split(" ").map(Number));

const solution = (T, data) => {
  for (let i = 0; i < T; i++) {
    for (let j = 0; j < T; j++) {
      for (let k = 0; k < T; k++) {
        if (data[j][i] && data[i][k]) {
          data[j][k] = 1;
        }
      }
    }
  }
};
solution(T, data);

console.log(data.map((row) => row.join(" ")).join("\n"));
