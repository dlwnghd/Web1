/**
 * 
 */

let replyList;
let check = false;

getList();

//댓글 등록
function insert(){
	let $content = $("#content").val();
	$.ajax({
		url: contextPath + "/board/ReplyWriteOk.re",
		type: "post",
		data: {boardNumber: boardNumber, replyContent: $content},
		success: function(){
			$("#content").val("");
			getList();
		}
	});
}

//댓글 목록
function getList(){
	$.ajax({
		url: contextPath + "/board/ReplyListOk.re", //요청할 URL
		type: "get", //실행할 서블릿 메소드 방식
//		data를 통해 JS 객체를 JSON으로 전송할 때 contentType은 text로 설정해야 한다.
		data: {"boardNumber": boardNumber}, //전송할 데이터(JS Object 형식으로 전송)
		contentType: "application/json; charset=utf-8", //전송할 데이터의 타입
		dataType: "json", //받을 데이터의 타입
		success: showList
	});
}

//댓글 목록
function showList(replies){
	replyList = replies;
    var text = "";
    if(replies != null && replies.length != 0){
        $.each(replies, function(index, reply){
            text += "<div id='reply'>"
            text += "<p class='writer'>" + reply.memberId +"</p>"
            text += "<div class='content' id='content"+ index +"' style='width:100%'>"
            text += "<pre>" + reply.replyContent + "</pre>"
            text += "</div>"
            if(memberNumber == reply.memberNumber){
                text += "<input type='button' id='ready" + index + "' class='primary' value='수정' onclick='readyToUpdate(" + index + ")'>";
                text += "<input type='button' id='ok" + index + "' class='primary' style='display:none;' value='수정 완료' onclick='update(" + index +")'>";
                //버튼 마다 삭제할 댓글의 번호를 같이 전달한다.
                text += "<input type='button' id='remove" + index + "' class='primary' value='삭제' onclick='remove(" + reply.replyNumber + ")'>"
            }
            text += "</div>"
        });
    }else{
        //댓글 없음
        text = "<p>댓글이 없습니다.</p>";
    }

   $("#replies").html(text);
}


//댓글 수정 버튼 클릭
function readyToUpdate(index){
	if(check){
		alert("이미 수정중인 댓글이 있습니다.");
		return;
	}
	var div = $("#content" + index);
	var updateReady = $("#ready" + index);
	var updateOk = $("#ok" + index);
	var remove = $("#remove" + index);
	console.log(remove);
	remove.replaceWith("<input type='button' id='cancel" + index +"' value='취소' onclick='updateCancel(" + index + ")'>");
	div.replaceWith("<textarea name='replyContent' id='content" + index +"' style='resize:none; border-radius:0; background:white'>" + div.text() + "</textarea>");
	
	check = true;
	
	updateReady.hide();
	updateOk.show();
}

//댓글 수정 취소
function updateCancel(index){
	
	check = false;
	
	var div = $("#content" + index);
	var updateReady = $("#ready" + index);
	var updateOk = $("#ok" + index);
	var cancel = $("#cancel" + index);
	
	updateReady.show();
	updateOk.hide();
	
	cancel.replaceWith("<input type='button' id='cancel" + index +"' value='삭제' onclick='remove(" + replyList[index].replyNumber + ")'>");
	div.replaceWith("<div class='content' id='content"+ index +"' style='width:100%'><pre>" + replyList[index].replyContent + "</pre></div>");	
}


//댓글 수정
function update(index){
	$.ajax({
		url: contextPath + "/board/ReplyUpdateOk.re",
		type: 'post',
//		JSON으로 데이터 전달할 때에는 아래와 같이 전달하고,
//		contentType:text로 반드시 설정한다. 생략 가능!
		data: {replyNumber: replyList[index].replyNumber, replyContent: $("#content" + index).val()},
		success: function(){
			getList();
			check = false;
		}
	});
}

//댓글 삭제
function remove(replyNumber){
	$.ajax({
		url: contextPath + "/board/ReplyDeleteOk.re",
		type: 'get',
		data: {replyNumber: replyNumber},
		success: function(){
			getList();
		}
	});
}













