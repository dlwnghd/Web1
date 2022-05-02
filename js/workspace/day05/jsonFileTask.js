// 상품명, 가격, 재고를 JS 객체에 프로퍼티로 담는다.
// JSON형식으로 변환한 뒤, day05/product.json으로 출력한다.
// day05/product.json에 있는 JSON 형식을 JS Object타입으로 변환한다.
// 각 프로퍼티를 출력한다.

let file = require('fs'); //node.js에 있는 모듈을 import한다.
let product = new Object();
let productJSON;

product.name = "가위";
product.price = 1800;
product.storage = 12;

productJSON = JSON.stringify(product);

// writeFile(경로, 작성할 내용, 인코딩 방식, 콜백함수(에러객체))
// file.writeFile("js/workspace/day05/product.json", productJSON, 'UTF-8', function(e){
//     if(e){
//         console.log(e);
//     }else{
//         console.log("파일 출력 성공");
//     }
// });

// readFile(경로, 인코딩, 콜백함수(에러객체, 내용))
file.readFile("js/workspace/day05/product.json", 'UTF-8', function(e, content){
    let product = JSON.parse(content);
    console.log('상품명: %s',product.name);
    console.log('가격: %s', product.price);
    console.log('재고: %s', product.storage);
});

