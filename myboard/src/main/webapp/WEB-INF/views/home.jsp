<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 현재 파일 위치에서 include 디렉토리의 header.jsp 파일의 코드를 가져와서 삽입 -->
<%@ include file = "include/header.jsp"%>


	<!-- 인기 게시판 -->
<div id="board-main">
	<div id="board-left">
		<h4>인기 게시판</h4>
		<ol>
			<c:forEach var="item" items="${recommend}" begin="0" end="4">
				<li><a href="board/detail?board_num=${item.board_num}">${item.board_title}</a></li>
			</c:forEach>		
		</ol>
	</div>
		
	<!-- 새로 생긴 게시판 -->
	<div id="board-right">
		<h4>새로 생긴 게시판</h4>
		<ul>
			<c:forEach var="item" items="${list}" begin="0" end="4">
				<li><a href="board/detail?board_num=${item.board_num}">${item.board_title}</a></li>
			</c:forEach>
		</ul>
	</div>
</div>

<!-- 네이버 tv 캐스트 -->
추천 콘텐츠
<div id="tv-wrapper">
	<div id="tv">
	</div>
	<div id="tv">
	</div>
	<div id="tv">
	</div>
</div>