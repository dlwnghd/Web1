// ["공", "일", "이",... , "구"] 배열이 필요하다
// "공일이삼사오육칠팔구"
// 입력받은 정수의 자리수 분리
// 각 자리수 정수가 위 배열의 인덱스번호로 활용

// 변경 버튼 클릭 시 준비한 getResult() 실행
// document.getElementById("change").onclick = getResult;
$("#change").click(getResult);

// 외부에서 사용자가 입력한 숫자를 전달받는다.
function changeToHangle(number){
    // const pTag = document.getElementById("result");
    const $pTag = $("#result");
    // const div = document.getElementById("round");
    const $div = $("#round");
    
    let hangle = "공일이삼사오육칠팔구";
    let result = "";
    // 1보다 작은 실수가 들어왔는 지 체크
    let check = false;

    // 숫자가 아닌 다른 문자를 작성했을 때
    if(isNaN(number)){
        // pTag.innerHTML = "숫자만 입력해주세요.";
        $pTag.text("숫자만 입력해주세요.")
        // div.innerHTML = "4";
        $div.text("4");
        return;
    }

    // 실수 중 1보다 작은 값이 들어왔다면,
    if(number < 1){
        // 영을 먼저 붙여준다.
        result += "영";
        check = true;
    }

    // 실수든 정수든 우선 3으로 표기한다.
    // div.innerHTML = "3";
    $div.text("3");

    // 사용자가 입력한 숫자의 자리수만큼 반복한다.
    for(let i in number){
        if(check){ // 위에서 영을 붙였다면, 공이 붙지 않도록 continue를 사용한다.
            check = false; 
            continue;
        }

        // 각 자리수를 처음부터 순서대로 접근하여 (number.charAt(i)),
        // hangle 문자열의 인덱스로 사용한다.
        // 해당 인덱스에는 한글이 있기 때문에 data에 차례로 누적 연결한다.
        let data = hangle[number.charAt(i)];
        if(!data){ // 마침표(점)가 있을 경우 undefined이기 때문에 false이다.
            result += "점"; // undefined를 "점"으로 변경한다.
            // div.innerHTML = "2";
            $div.text("2");
            continue;
        }
        result += data;
    }
    // pTag.innerHTML = result;
    $pTag.text(result);
}

function getResult(){
    // const input = document.querySelector("input[name='input']").value;
    const input = $("input[name='input']").val();
    changeToHangle(input);
}