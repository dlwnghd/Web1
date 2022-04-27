/*
    contents: variable
*/

// 동적 바인딩 : 컴파일 시 값에 따라 자료형이 동적으로 결정된다.
data = 10;
console.log(data);
console.log(typeof(data));

var age;
console.log(age);

console.log(data2);
var data2 = 10;
console.log(data2);

var data3 = "절대 수정 금지";
// 되도록 var를 사용하면 변수를 선언한다
data3 = "안녕";
console.log(data3);