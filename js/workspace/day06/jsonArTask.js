/////////////////////////////////////⭐강사님풀이⭐//////////////////////////////////////////
// ⭐상품명, 가격, 재고를 프로퍼티로 담고 있는 Object를 3개 선언한다.
// ⭐3개의 Object를 1개의 Array객체에 모두 담는다.
// ⭐JSON으로 변경시킨다.
// ⭐day06/shop.json으로 출력한다.
// ⭐readFile을 사용해서 day06/shop.json을 읽어온다.
// ⭐기존의 JSON 내용을 Array 객체로 변환한다.
// ⭐총 가격과 총 재고 수를 Object에 담은 후 day06/sum.json으로 출력한다.
// ⭐상품이 3개이기 때문에 프로토타입을 사용하는 것이 적합하다.

// file객체 만들어주기
let file = require("fs");

// ⭐Product라는 이름의 프로토타입 Object를 선언
// ⭐상품이 3개이기 때문에 프로토타입을 사용하는 것이 적합하다.
// ⭐함수 vs 프로토타입   : 프로토타입은 대문자로 시작한다.
function Product(name, price, stock){   // 외부에서 이름, 가격, 재고를 받아옴
    this.name = name;   // 나라는 객체의 name에 외부에서 받아온 name 데이터와 타입이라고 선언
    this.price = price; // 나라는 객체의 price에 외부에서 받아온 price 데이터와 타입이라고 선언
    this.stock = stock; // 나라는 객체의 stock에 외부에서 받아온 stock 데이터와 타입이라고 선언
    // --------------------------------------------😭90점😭---------------------------------------------
    this.json = JSON.stringify(this);   // ⭐ 나라는 객체의 json에 나라는 객체를 JSON화해서 선언
    // -------------------------------------------👏100점👏---------------------------------------------
}

// ⭐3개의 Object를 1개의 Array객체에 모두 담는다.
// products라는 이름의 Array 선언
let products = new Array();
// push를 이용해 Product타입의 객체들을 추가
// json들이 products라는 Array에 들어감
products.push(new Product('마우스', 15000, 3).json);
products.push(new Product('키보드', 60000, 8).json);
products.push(new Product('야구공', 3500, 50).json);

// JSON타입의 Array로 호출
console.log(products);

// Array로 호출
console.log(products.toString());


// ⭐JSON으로 변경시킨다.
// ⭐day06/shop.json으로 출력한다.
// 파일을 쓸때는 데이터의 타입이 string 또는 instance of Buffer, TypedArray, 또는 DataView야 하기 때문에 
// toString으로 Array로 호출한뒤 [대괄호]를 씌워서 JSON타입으로 작성하여 저장한다.
// file.writeFile('js/workspace/day06/shop.json', "[" + products.toString() + "]", 'utf-8', function(e){
//     if(e){
//         console.log(e);
//     }else{
//         console.log("출력 성공!");
//     }
// }); 

// ⭐readFile을 사용해서 day06/shop.json을 읽어온다.
// 콜백함수에서 연산한 결과는 해당 영역밖에서는 사용할 수 없다.
// 따라서 연산한 결과를 활용하는 코드도 해당 영역 안에서 작성해야 한다.
file.readFile('js/workspace/day06/shop.json', 'utf-8', getTotal);

function getTotal(e, datas){
    let sumObject = new Object();
    let totalPrice = 0;
    let totalStock = 0;

    // Array타입의 객체 products ???
    // JS Object타입의 Array로 변경 ???
    products = JSON.parse(datas);   

    // // 타입과 데이터 확인
    // console.log(typeof(products));
    // console.log(products);

    // ⭐총 가격과 총 재고 수를 Object에 담은 후 day06/sum.json으로 출력한다. -1
    products.map(function(v){return v.price * v.stock;}).forEach(function(v){totalPrice += v;});
    products.map(function(v){return v.stock;}).forEach(function(v){totalStock += v;});

    sumObject.totalPrice = totalPrice;
    sumObject.totalStock = totalStock;
    // JSON으로 변환
    sumObject = JSON.stringify(sumObject);

    // ⭐총 가격과 총 재고 수를 Object에 담은 후 day06/sum.json으로 출력한다. -2
    file.writeFile('js/workspace/day06/sum.json', sumObject, 'utf-8', function(e){
        if(e){
            console.log(e);
        }else{
            console.log("출력 성공!");
        }
    });
}