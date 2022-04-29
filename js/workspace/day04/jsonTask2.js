// 비행기에 승객이 2명이 있다.

// 1번, 2번 승객
// 이름, 나이, 성별

// js object에 담고 JSON으로 변환하기
// JSON으로 변환한 다음 타입 확인
// JSON을 js object로 변환한 뒤 이름과 나이, 성별 출력
// 이 때 이름, 나이, 성별 출력은 메소드로 선언한다.
function Passenger(name, age, gender){
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.intro = function(){
        with(console){
            log(this.name);
            log(this.age);
            log(this.gender);
        }
    }
}

let passenger1 = new Passenger("한동석", 20, "남자");
let passenger2 = new Passenger("조수민", 21, "여자");
let plane = new Object();

plane.passenger1 = passenger1;
plane.passenger2 = passenger2;

console.log(plane);
plane.passenger1.intro();
plane.passenger2.intro();

// js object 프로퍼티 중에서 메소드는 JSON으로 변환 시 없어진다.
// 이는, JSON의 목적이 데이터 전달이므로, 데이터가 아니라고 판단되면 없앤 뒤 변환된다.
let planeJSON = JSON.stringify(plane);
console.log(planeJSON);
console.log(typeof planeJSON);

plane = JSON.parse(planeJSON);
console.log(plane);