/* JS에서는 오버로딩을 지원하지 않는다. */
// function add(num1, num2, num3){
//     return num1 + num2 + num3;
// }

// function add(num1, num2){
//     return num1 + num2;
// }

// console.log(add(1, 3));
// console.log(add(1, 3, 5));

// 가변인자 : 여러 개의 값을 전달받을 수 있는 매개변수
// (...가변인자명)
// 몇 개의 값이 전달될 지 알 수 없을 때
// 각각의 값이 공통 요소일 때(순서가 상관없고, 특정 값만 가져올 필요 없을 때)
// function add(...nums){
//     let total = 0;

//     for(let i=0; i<nums.length; i++){
//         total += nums[i];
//     }

//     return total;
// }

// console.log(add(1, 3));
// console.log(add(1, 3, 5));

// 이름, 나이, 성별을 입력받고
// 이름이 없다면 "무명(no name)", 성별이 없다면 "선택 안함"을 대신 출력한다.
function intro(age, ...datas){
    let name = datas[0] || "무명(no name)";
    let gender = datas[1] || "선택 안함";

    console.log(name);
    console.log(age + "살");
    console.log(gender);
}

intro(10);
intro(10, "한동석", "남자");
intro(10, "한동석");

// undefined, "", 0은 조건식 자리에 작성하면 false로 판단한다.
// if(!undefined){
//     console.log("undefined");
// }

// if(!0){
//     console.log("0");
// }

// if(!""){
//     console.log("\"\"");
// }

// 문자열에 있는 includes()메소드에 조회할 값을 전달하면
// 포함되어 있을 때 true, 없을 때에는 false이다.
// console.log("ABC".includes("A"));
// console.log("ABC".includes("Z"));

// 값이 없을 때 초기값을 설정한다.
// 단, false로 취급되는 값이 들어오면 초기값이 들어가게 된다.
// var data;
// data = data || 10;
// console.log(data);