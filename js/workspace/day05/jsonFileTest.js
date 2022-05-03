let file = require('fs'); //node.js에 있는 모듈을 import한다.
let user = new Object();
let userJSON;

user.name = "이주홍";
user.id = "ljh1234";
user.pw = "1234";

userJSON = JSON.stringify(user);

// writeFile(경로, 작성할 내용, 인코딩 방식, 콜백함수(에러객체))
// file.writeFile("js/workspace/day05/user.json", userJSON, 'UTF-8', function(e){
//     if(e){
//         console.log(e);
//     }else{
//         console.log("파일 출력 성공");
//     }
// });

// readFile(경로, 인코딩, 콜백함수(에러객체, 내용))
file.readFile('js/workspace/day05/user.json', 'UTF-8', function(e, content){
    let user = JSON.parse(content);
    console.log(user.name);
    console.log('아이디: %s', user.id);
    console.log(user.pw);
});