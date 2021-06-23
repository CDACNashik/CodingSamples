// get values from productinfo.js
// console.log(__dirname);

answer = require(__dirname+'\\productinfo');
// answer = require('./productinfo');
console.log(answer);

console.log(answer.x1);
console.log(answer['x1']);
console.log(answer.x3[0]);

console.log(answer.x4() );