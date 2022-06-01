/**
 * 
 */

// 주소 찾기(Daum API)
function find() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = ''; // 주소 변수
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById("address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("addressDetail").focus();
        }
    }).open();
}

//이용 약관
const $all = $("#term");
const $inputs = $(".terms");

$all.on('click', function(){
    if($(this).is(":checked")){
        $inputs.prop('checked', true);
    }else{
        $inputs.prop('checked', false);
    }
});

$inputs.on('click', function(){
    var check = true;
    if(!$(this).is(":checked")){
        $all.prop('checked', false);
    }

    if($inputs.filter(":checked").length == 2){
        $all.prop('checked', true);
    }
});

//약관 펼쳐보기
const aTags = $("a.showTerm");
const textAreas = $("textArea.term-content");
let checkTerm1 = -1;
let checkTerm2 = -1;
aTags.on('click', function(e){
	e.preventDefault();
	
	if($(this).attr("href") == "term1-content"){
		$("#term1-content").slideToggle(function(){
			//토글이 끝나고 나서 실행될 기능 작성
			checkTerm1 *= -1;
			$(aTags[0]).text(checkTerm1 > 0 ? "닫기 X" : "펼쳐보기");
		});
		
	}else if($(this).attr("href") == "term2-content"){
		$("#term2-content").slideToggle(function(){
			checkTerm2 *= -1;
			$(aTags[1]).text(checkTerm2 > 0 ? "닫기 X" : "펼쳐보기");
		});
	}
});

//아이디 중복검사
let check = false;

function checkId(memberId){	/* 사용자가 입력한 memberId를 전달받음 */
	console.log(memberId);
	$.ajax({
		url: contextPath + "/member/MemberCheckIdOk.me?memberId=" + memberId,
		type: "get", /* get방식으로 정보를 보냄 */
		dataType: "json", /* 전달받을 데이터 타입: json */
		success: function(result){
			const $result = $("span#result");
			if(result.result == "success"){	/* 전달받은 데이터가 "success"라면 */
				$result.text("사용가능한 아이디입니다.");
				$result.css("color", "blue");
				check = true;	// 사용 가능한 아이디 확인용
			}else{	/* 전달받은 데이터가 그 외라면 */
				$result.text("중복된 아이디입니다.");
				$result.css("color", "red");
				check = false;
			}
		}
	});
}

/*사용자가 Id에 입력한 해당 값과 비교*/
$("input#memberId").keyup(function(){ /* input태그에 Id가 memberId인 친구에게 keyup이벤트를 줌*/
	checkId($(this).val()); /* 사용자가 입력한 값을 가져옴 */
})

/* join.jsp에서 사용할 send() function */
function send(){
	
	// check가 false라면 이미 존재하는 아이디이므로
	if(!check){
		alert("아이디를 다시 확인해주세요.");
		return;
	}

	// "전체동의" 체크박스에 체크가 되어있지 않다면
	if(!$all.is(":checked")){
		alert("약관 동의가 필요합니다.");
		return;
	}
	
	joinForm.submit();
}














