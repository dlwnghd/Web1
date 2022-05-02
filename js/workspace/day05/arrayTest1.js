// js의 Array객체는 길이를 설정하지 않아도
// 원하는 인덱스에 원하는 값을 바로 추가할 수 있다.
// 또한 타입이 지정되어 있지 않기 때문에 다양한 타입도 동시에 담을 수 있다.

// var datas = [];
// // console.log(typeof datas);
// datas[0] = 10;
// console.log(datas);
// datas[3] = 30;
// console.log(datas);
// console.log(datas.length);

var datas = [20, 5, 6, 12, 10];
// push(): 가장 마지막에 값 추가
datas.push(19);
console.log(datas);
console.log(datas[3]);

// join(): 원하는 구분점을 문자열로 전달하여 각 요소를 전달한 구분점으로 구분한 뒤 문자열로 리턴
console.log(datas.join(":"));

// slice(begin, end): 원하는 부분을 추출하기 위해 시작 인덱스(inclusive)와 마지막 인덱스(exclusive)를 전달한다.
console.log(datas.slice(1, 3));
// slice(begin): begin부터 마지막까지 추출한다.
console.log(datas.slice(1));

// forEach(function(각 요소를 담을 매개변수){})
datas.forEach(function(value){
    console.log(value);
});

// forEach(function(각 요소를 담을 매개변수, 인덱스, Array객체){})
datas.forEach(function(value, index, ar){
    ar[index] = value * value;;
});

console.log(datas);

// indexOf(값): 값을 해당 Array에서 찾은 뒤 인덱스 번호 리턴
console.log(datas.indexOf(100));
console.log(datas.indexOf(1));

// map(콜백함수(요소){return 변경시킨 값;})
datas.map(function(v){return v*2;}).forEach(function(v){console.log(v);});

/* ************************************************************************ */

let week = new Array(7);

// week.push("월");
// week.push("화");
// week.push("수");
// week.push("목");
// week.push("금");
// week.push("토");
// week.push("일");

// console.log(week);

// let i = 0;

// week[i++] = "월";
// week[i++] = "화";
// week[i++] = "수";
// week[i++] = "목";
// week[i++] = "금";
// week[i++] = "토";
// week[i++] = "일";

// toString()을 사용하면 각 요소가 ,로 구분되어 문자열로 리턴된다.
// console.log(week.toString());

week = new Array("월", "화", "수", "목", "금", "토", "일")
week.forEach(function(v) {console.log(v);});