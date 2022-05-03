let file = require('fs');

let train = new Array();
let hong = {name: '홍길동', age: 20, level: 1};
let lee = {name: '이수민', age: 40, level: 2};
let jang = {name: '장보고', age: 19, level: 3};

train.push(hong);
train.push(lee);
train.push(jang);

console.log(train);

let trainJSON = JSON.stringify(train);
console.log(trainJSON);

// file.writeFile('js/workspace/day05/train.json', trainJSON, "utf-8", function(e){
//     if(e){
//         console.log(e);
//     }else{
//         console.log("출력 성공");
//     }
// });

// train.json을 가져와서 객체로 변환 후
// level 프로퍼티로 변경하여 forEach를 통해 출력한다.
// 다른 프로퍼티가 필요 없기 때문에 객체를 level로 변경해야 한다.
file.readFile('js/workspace/day05/train.json', 'utf-8', function(e, content){
    let trainAr = JSON.parse(content);
    trainAr.map(function(v){return v.level;}).forEach(function(v){console.log(v)});

    // for(let i in trainAr){
    //     console.log(trainAr[i].level);
    // }
});