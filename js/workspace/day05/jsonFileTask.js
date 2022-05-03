// 상품명, 가격, 재고를 JS 객체에 프로퍼티로 담는다.
// JSON형식으로 변환한 뒤, day05/product.json으로 출력한다.
// day05/product.json에 있는 JSON 형식을 JS Object타입으로 변환한다.
// 각 프로퍼티를 출력한다.
let file = require('fs');
let product = new Object();
let productJSON;

product.name = "굴렁쇠";
product.price = 4900;
product.stock = 4;

productJSON = JSON.stringify(product);

// file.writeFile('js/workspace/day05/product.json', productJSON, 'utf-8', function(e){
//     if(e){
//         console.log(e)
//     }else{
//         console.log("파일 출력 성공!");
//     }
// });

file.readFile('js/workspace/day05/product.json', 'utf-8', function(e, content){
    let product = JSON.parse(content);
    console.log(product.name);
    console.log(product.price);
    console.log(product.stock);
});