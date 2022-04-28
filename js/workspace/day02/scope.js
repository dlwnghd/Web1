// 함수가 아닌 다른 영역(제어문 영역)에서는 scope로 판단하지 않는다.
if(10 > 1){
    // 지역변수 같지만 함수의 scope가 아니가 때문에 영역 밖에서도 사용할 수 있다.
    var data4 =  10;
}

console.log(data4);

for(var i=0; i<10; i++){

}

console.log(i);

var x; // 전역변수

function f(){
    var y;  // 지역 변수
    x = 10; // 전역 변수
    y = 10; // 지역 변수
    z = 10; // 전역 변수
}

f();
console.log("x : " + x);
console.log("z : " + z);
console.log(y);