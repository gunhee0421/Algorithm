const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  const [n, m] = input[0].split(" ").map(Number);
  const [trueLength, ...members] = input[1].split(" ").map(Number);
  const party = input.slice(2).map((l) => l.split(" ").slice(1).map(Number));
  const trueSet = new Set(members);

  for (let i = 0; i < n; i++) {
    party.forEach((p) => {
      const trueInParty = p.some((h) => trueSet.has(h));
      if (trueInParty) {
        p.forEach((h) => trueSet.add(h));
      }
    });
  }

  let count = 0;

  party.forEach((p) => {
    const trueInParty = p.some((h) => trueSet.has(h));
    if (!trueInParty) {
      count++;
    }
  });

  return count;
}

console.log(solution(input));
