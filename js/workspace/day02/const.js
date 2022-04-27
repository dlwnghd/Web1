// 1~10까지 출력하는 함수
function printFrom1To10(){
    for(let i=0; i<10; i++){
        console.log(i + 1);
    }
}

printFrom1To10();

// 1~10까지의 합을 출력하는 함수
function getTotal(){
    let sum = 0;
    for(let i=0; i<10; i++){
        sum = sum + i;
    }
    console.log(sum);
}

getTotal();


// 1~n까지의 합을 출력하는 함수
function get_n_Total(n){
    let sum = 0;
    for(let i=0; i<n; i++){
        sum = sum + i;
    }
    console.log(sum);
}

get_n_Total(20);