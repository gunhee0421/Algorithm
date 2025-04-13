const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
1. N높이의 삼각형으로 별찍기
2. N이 3이되면 동일한 삼각형이 그려지도록
3. 2차원 배열이 아닌, 문자열 누적으로 += 방식으로 시간복잡도 낮추기 가능 js의 경우
*/
function solution(input) {
  const N = Number(input[0]);
  const graph = draw(N);

  for (let i = N; i > 0; i--) {
    graph[i - 1] = " ".repeat(N - i) + graph[i - 1] + " ".repeat(N - i);
  }
  return graph.join("\n");

  function draw(N) {
    if (N === 3) return ["*", "* *", "*****"];

    const res = Array.from({ length: N }, () => "");
    const sub = draw(N / 2);

    sub.forEach((v, i) => (res[i] += v));
    sub.forEach((v, i) => {
      res[N / 2 + i] += v;
      res[N / 2 + i] += " ".repeat((N / 2 - i) * 2 - 1);
      res[N / 2 + i] += v;
    });
    return res;
  }
}

console.log(solution(input));
