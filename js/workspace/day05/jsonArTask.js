// 상품명, 가격, 재고를 프로퍼티로 담고 있는 Object를 3개 선언한다.
// 3개의 Object를 1개의 Array객체에 모두 담는다.
// JSON으로 변경시킨다.
// js/workspace/day05/shop.json으로 출력한다.
// readFile을 사용해서 js/workspace/day05/shop.json을 읽어온다.
// 기존의 JSON 내용을 Array 객체로 변환한다.
// 총 가격과 총 재고 수를 Object에 담은 후 js/workspace/day05/sum.json으로 출력한다.
// 상품이 3개이기 때문에 프로토타입을 사용하는 것이 적합하다.

function Product(name, price, storage){
    this.name = name;
    this.price = price;
    this.storage = storage;
    this.intro = function(){
        with(console){
            log(this.name);
            log(this.price);
            log(this.storage);
        }
    }
}

let file = require('fs');

let mouse = new Product('마우스',20000,1);
let keyboard = new Product('키보드',40000,2);
let monitor = new Product('모니터', 200000,  3);
let shop = new Object();

shop.mouse = mouse;
shop.keyboard = keyboard;
shop.monitor = monitor;

console.log(shop);

let shopJSON = JSON.stringify(shop);