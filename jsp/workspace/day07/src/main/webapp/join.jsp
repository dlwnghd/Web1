<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
   <section>
      <form action="JoinOk.me" name="joinForm" method="post">
         <p>
            <label>
               아이디 : <input type="text" name="memberId">
            </label>
            <input type="button" value="중복확인" onclick="checkId()">
            <p id="result"></p>
         </p>
         <p>
            <label>
               이름 : <input type="text" name="memberName">
            </label>
         </p>
         <p>
            <label>
               비밀번호 : <input type="password" name="memberPw">
            </label>
         </p>
         <p>
            <label>
               비밀번호 확인 : <input type="password" id="memberPw">
            </label>
         </p>
         <p>
            성별 : 
            <label>
               남자 <input type="radio" name="memberGender" value="M">
            </label>
            <label>
               여자 <input type="radio" name="memberGender" value="W">
            </label>
            <label>
               선택안함 <input type="radio" name="memberGender" value="N">
            </label>
         </p>
         <p>
            <input type="text" id="sample5_address" placeholder="주소" name="memberAddress">
            <input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
            <input type="text" name="memberAddressDetail" placeholder="상세 주소">
            <div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>
         </p>
         <p>
            <input type="button" value="가입 완료" onclick="join()">
         </p>
      </form>
   </section>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=37a9abf54fb9bec320d474d06c964451&libraries=services"></script>
<script>
   function checkId(){
      $.ajax({
         url: "/day07/CheckIdOk.me",
         type: "get",
         data: {memberId: $("input[name='memberId']").val()},
         contentType: "application/json; charset=utf-8",
         dataType: "json",
         success: function(result){
            if(result.check){
               $("p#result").text("중복된 아이디입니다.");
            }else{
               $("p#result").text("사용가능한 아이디입니다.");
            }
         },
         error: function(request, status, error){
            console.log("실패..");
            console.log(request);
            console.log(status);
            console.log(error);
         }
      });
   }

   function join(){
      joinForm.submit();
   }

    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
            level: 5 // 지도의 확대 레벨
        };

    //지도를 미리 생성
    var map = new daum.maps.Map(mapContainer, mapOption);
    //주소-좌표 변환 객체를 생성
    var geocoder = new daum.maps.services.Geocoder();
    //마커를 미리 생성
    var marker = new daum.maps.Marker({
        position: new daum.maps.LatLng(37.537187, 127.005476),
        map: map
    });


    function sample5_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = data.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample5_address").value = addr;
                // 주소로 상세 정보를 검색
                geocoder.addressSearch(data.address, function(results, status) {
                    // 정상적으로 검색이 완료됐으면
                    if (status === daum.maps.services.Status.OK) {

                        var result = results[0]; //첫번째 결과의 값을 활용

                        // 해당 주소에 대한 좌표를 받아서
                        var coords = new daum.maps.LatLng(result.y, result.x);
                        // 지도를 보여준다.
                        mapContainer.style.display = "block";
                        map.relayout();
                        // 지도 중심을 변경한다.
                        map.setCenter(coords);
                        // 마커를 결과값으로 받은 위치로 옮긴다.
                        marker.setPosition(coords)
                    }
                });
            }
        }).open();
    }
</script>
</html>










