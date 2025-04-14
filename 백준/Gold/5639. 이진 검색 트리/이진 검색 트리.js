const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

/*
1. 전위순회 -> 후위 순회로 변경
2. 왼쪽은 무조건 정점보다 작고, 오른쪽은 무조건 정점보다 크다.
3. 트리를 만들고, 후위순회로 출력
*/
class Node {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}
class Tree {
  constructor() {
    this.root = null;
  }
  insert(value) {
    const newNode = new Node(value);
    if (this.root === null) {
      this.root = newNode;
    } else {
      this.insertNode(this.root, newNode);
    }
  }
  insertNode(node, newNode) {
    if (newNode.value < node.value) {
      if (node.left === null) {
        node.left = newNode;
      } else {
        this.insertNode(node.left, newNode);
      }
    } else {
      if (node.right === null) {
        node.right = newNode;
      } else {
        this.insertNode(node.right, newNode);
      }
    }
  }
}
function solution(input) {
  const arr = input.map((v) => Number(v));

  const tree = new Tree();

  arr.forEach((v) => {
    tree.insert(v);
  });

  const res = [];
  postOrder(tree.root, res);

  return res.join("\n");

  function postOrder(node, res) {
    if (node === null) return;
    postOrder(node.left, res);
    postOrder(node.right, res);
    res.push(node.value);
  }
}

console.log(solution(input));
