<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML>
<!--
	Altitude by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
	<head>
		<title>게시글 수정</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<style>
			form textarea{
				border-radius:0; 
				resize:none;
				color:black !important;
			}
			
			form div#reply{
				display:flex;
				margin-bottom:3%;
			}
			
			input[type='submit']:not(#register), input[type='button'] {border-radius:0;}
			
			ul.actions li {
			    padding: 0 0 0 0.2em;
			}
			
			input#board_title{
				border-radius: 0;
				border: none;
				text-align: left;
				font-size: 1.75em;
				font-weight: 500;
				line-height: 1.5;
				letter-spacing: 0.1em;
				padding:0;
			}
			
			input[type='file']{
				display:none;
			}
			
			div.files{
				text-align:center;
				margin-right: 3%;
			}
			
			textarea {
				font-size: 1em;
    			font-weight: 600;
    			letter-spacing: 0.1em;
			}
			
		</style>
	</head>
	<body class="is-preload">
		<c:set var="page" value="${page}"/>
		<c:set var="board" value="${board}"/>
		<!-- Page Wrapper -->
			<div id="page-wrapper">
				<!-- Wrapper -->
					<div class="wrapper">
						<div class="inner">
							<jsp:include page="/app/fix/header.jsp"/>
						</div>
					</div>

				<!-- Wrapper -->
					<div class="wrapper">
						<div class="inner">

							<!-- Main -->
							<section class="main">
								<a href="#" class="image main"><img src="${pageContext.request.contextPath}/images/boardView.png" alt="" /></a>
								<div class="col-12">
									<ul class="actions" style="display:flex; justify-content:flex-end;">
										<li><input type="button" value="목록" class="primary" onclick="location.href = '${pageContext.request.contextPath}/board/BoardListOk.bo'"/></li>
									</ul>
								</div>
								<form action="${pageContext.request.contextPath}/board/BoardUpdateOk.bo" name="updateForm" method="post">
									<input type="hidden" name="boardNumber" value="${board.getBoardNumber()}">
									<input type="hidden" name="page" value="${page}">
									<header class="major">
										<p>
											<input name="boardTitle" type="text" placeholder="제목 입력" value="${board.getBoardTitle()}">
										</p>
										<p style="text-align:left; margin-bottom:1%; margin-top:-1.75em;">작성자 : ${board.getMemberId()}</p>
									</header>
									<div style="margin-top:3%;">
										<textarea name="boardContent" placeholder="내용 작성" style="resize:none;" rows="30">${board.getBoardContent()}</textarea>
									</div>
									<ul class="actions" style="display:flex; justify-content:center; margin-top:3%;">
										<li><input type="button" value="수정완료" class="primary" onclick="updateForm.submit()"/></li>
										<li><input type="button" value="취소" onclick="history.back()"/></li>
									</ul>
								</form>
							</section>
						</div>
					</div>

				<!-- Wrapper -->
					<div class="wrapper">
						<div class="inner">

							<!-- Footer -->
								<footer id="footer">
									<section class="links">
										<div>
											<h3>Magna</h3>
											<ul class="plain">
												<li><a href="#">Aliquam tempus</a></li>
												<li><a href="#">Ultrecies nul</a></li>
												<li><a href="#">Gravida ultricies</a></li>
												<li><a href="#">Commodo etiam</a></li>
											</ul>
										</div>
										<div>
											<h3>Feugiat</h3>
											<ul class="plain">
												<li><a href="#">Morbi sem lorem</a></li>
												<li><a href="#">Praes sed dapi</a></li>
												<li><a href="#">Sed adipis nullam</a></li>
												<li><a href="#">Fus dolor lacinia</a></li>
											</ul>
										</div>
										<div>
											<h3>Tempus</h3>
											<ul class="plain">
												<li><a href="#">Donecnec etiam</a></li>
												<li><a href="#">Aapibus sedun</a></li>
												<li><a href="#">Namnulla tempus</a></li>
												<li><a href="#">Morbi set amet</a></li>
											</ul>
										</div>
										<div>
											<h3>Aliquam</h3>
											<ul class="plain">
												<li><a href="#">Lorem prasent dia</a></li>
												<li><a href="#">Nellentes ipsum</a></li>
												<li><a href="#">Diamsed arcu dolor</a></li>
												<li><a href="#">Sit amet cursus</a></li>
											</ul>
										</div>
									</section>
									<ul class="contact-icons">
										<li class="icon solid fa-home">1234 Fictional Street #5432 Nashville, TN 00000-0000</li>
										<li class="icon solid fa-phone"><a href="#">(000) 000-0000</a></li>
										<li class="icon solid fa-envelope"><a href="#">info@untitled.tld</a></li>
									</ul>
									<p class="copyright">&copy; Untitled. All rights reserved.</p>
								</footer>

						</div>
					</div>

			</div>

		<!-- Scripts -->
			<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
	</body>
</html>