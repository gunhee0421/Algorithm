const fs = require('fs'); const inputData = fs.readFileSync(0,'utf8').toString().split('\n')
const TotalA = parseInt(inputData[0]);
let caseNum = parseInt(inputData[1]);
let sum = 0
for(let i = 2; i < caseNum+2 ; i++){
let data = inputData[i].split(' ');
let realS = parseInt(data[0]) * parseInt(data[1])
sum += realS 
}

if(sum === TotalA){
console.log("Yes")
} else {
console.log("No")
}