// ⭐상품명, 가격, 재고를 프로퍼티로 담고 있는 Object를 3개 선언한다.
// ⭐3개의 Object를 1개의 Array객체에 모두 담는다.
// ⭐JSON으로 변경시킨다.
// ⭐day05/shop.json으로 출력한다.
// ⭐readFile을 사용해서 day05/shop.json을 읽어온다.
// ⭐기존의 JSON 내용을 Array 객체로 변환한다.
// ⭐총 가격과 총 재고 수를 Object에 담은 후 day05/sum.json으로 출력한다.
// 상품이 3개이기 때문에 프로토타입을 사용하는 것이 적합하다.   앞글자가 대문자면 프로덕트

// ⭐상품명, 가격, 재고를 프로퍼티로 담고 있는 Object를 3개 선언한다.
let file = require('fs');

mouse = {name: '마우스', price: 15000, stock: 20};
keyboard = {name: '키보드', price: 20000, stock: 30};
USB = {name: 'usb', price: 19000, stock: 100};

product = new Object();

product.product1 = mouse;
product.product2 = keyboard;
product.product3 = USB;

// 확인용
// console.log(product);

// ⭐3개의 Object를 1개의 Array객체에 모두 담는다.
let shop= new Array();
shop.push(product.product1);
shop.push(product.product2);
shop.push(product.product3);

// 확인용
// console.log(shop);

// ⭐JSON으로 변경시킨다.
let shopJSON = JSON.stringify(shop);

// 확인용
// console.log(shopJSON);


// ⭐day05/shop.json으로 출력한다.
file.writeFile('js/workspace/day05/shop.json', shopJSON, "utf-8", function(e){
    if(e){
        console.log(e);
    }else{
        console.log("출력 성공");
    }
});

// ⭐readFile을 사용해서 day05/shop.json을 읽어온다.
file.readFile('js/workspace/day05/shop.json', 'utf-8', function(e, content){
    let shopAr = JSON.parse(content);
    shopAr.map(function(v){return v;}).forEach(function(v){console.log(v)});

    // for(let i in shopAr){
    //     console.log(shopAr[i].level);
    // }
});

// ⭐기존의 JSON 내용을 Array 객체로 변환한다.
let sum = new Array();
sum = JSON.parse(shopJSON);
console.log(sum);

// 총 가격과 총 재고 수를 Object에 담은 후 day05/sum.json으로 출력한다.
product_sum = new Object();
product_sum.total_price = 0;
product_sum.total_stock = 0;

for(let i = 0; i < sum.length; i++){
    product_sum.total_price += parseInt(sum[i].price * sum[i].stock);
    product_sum.total_stock += parseInt(sum[i].stock);
};

// 확인용
console.log(product_sum);

// JSON으로 변환
sumJSON = JSON.stringify(product_sum);

file.writeFile('js/workspace/day05/sum.json', sumJSON, "utf-8", function(e){
    if(e){
        console.log(e);
    }else{
        console.log("파일 출력 성공");
    }
});




/////////////////////////////////////⭐강사님풀이⭐//////////////////////////////////////////
// 상품명, 가격, 재고를 프로퍼티로 담고 있는 Object를 3개 선언한다.
// 3개의 Object를 1개의 Array객체에 모두 담는다.
// JSON으로 변경시킨다.
// day05/shop.json으로 출력한다.
// readFile을 사용해서 day05/shop.json을 읽어온다.
// 기존의 JSON 내용을 Array 객체로 변환한다.
// 총 가격과 총 재고 수를 Object에 담은 후 day05/sum.json으로 출력한다.
// 상품이 3개이기 때문에 프로토타입을 사용하는 것이 적합하다.
let file = require("fs");

function Product(name, price, stock){
    this.name = name;
    this.price = price;
    this.stock = stock;
    this.json = JSON.stringify(this);
}

let products = new Array();
products.push(new Product('마우스', 15000, 3).json);
products.push(new Product('키보드', 60000, 8).json);
products.push(new Product('야구공', 3500, 50).json);

console.log(products.toString());

// file.writeFile('day06/shop.json', "[" + products.toString() + "]", 'utf-8', function(e){
//     if(e){
//         console.log(e);
//     }else{
//         console.log("출력 성공!");
//     }
// }); 

// 콜백함수에서 연산한 결과는 해당 영역밖에서는 사용할 수 없다.
// 따라서 연산한 결과를 활용하는 코드도 해당 영역 안에서 작성해야 한다.
file.readFile('day06/shop.json', 'utf-8', getTotal);

function getTotal(e, datas){
    let sumObject = new Object();
    let totalPrice = 0;
    let totalStock = 0;

    products = JSON.parse(datas);

    products.map(function(v){return v.price * v.stock;}).forEach(function(v){totalPrice += v;});
    products.map(function(v){return v.stock;}).forEach(function(v){totalStock += v;});

    sumObject.totalPrice = totalPrice;
    sumObject.totalStock = totalStock;
    sumObject = JSON.stringify(sumObject);

    file.writeFile('day06/sum.json', sumObject, 'utf-8', function(e){
        if(e){
            console.log(e);
        }else{
            console.log("출력 성공!");
        }
    });
}