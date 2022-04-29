// JSON.parse(): JSON을 JS Object로 변경할 때 사용.
// JSON.stringify(): JS Object를 JSON으로 변경할 때 사용.

user = {name: '한동석', age: 20};
// JSON.parse(user); // js object는 json으로 판단되지 않기 때문에 오류!
userJSON = JSON.stringify(user);
console.log(typeof userJSON);
console.log(typeof user);

console.log(JSON.parse(userJSON).name);
console.log(userJSON.name);
