const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
 */
function solution(input) {
  const T = Number(input[0]);
  const moneys = input.splice(1).map(Number);

  for (let i = 0; i < T; i++) {
    let money = moneys[i];
    let coins = [25, 10, 5, 1];
    const res = [];

    for (let j = 0; j < coins.length; j++) {
      const coin = coins[j];
      const count = Math.floor(money / coin);
      res.push(count);
      money -= count * coin;
    }

    console.log(res.join(" "));
  }
}

solution(input);
