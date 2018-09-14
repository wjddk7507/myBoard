<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 현재 파일 위치에서 include 디렉토리의 header.jsp 파일의 코드를 가져와서 삽입 -->
<%@ include file = "include/header.jsp"%>

<div id="container">

	<div style="width:800px; margin:auto;">
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
					<c:forEach var="item" items="${order_date}" begin="0" end="4">
						<li><a href="board/detail?board_num=${item.board_num}">${item.board_title}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>	
	<!-- 네이버 tv 캐스트 -->
	추천 콘텐츠
	<div id="tv-wrapper">	
		<div style="width:1800px;margin:auto;">		
			<ul style="list-style:none">
				<c:forEach var="item" items="${content}" varStatus="status" begin="0" end="3">
					<li style="float:left; width:25%">
						<div id="tv">
							<a href="${item.src}">
								<img src="${item.img }" class="tv-img">
							</a>
						</div>
						<div>${item.title}</div>
					</li>
				</c:forEach>
			</ul>			
		</div>		
	</div>
	 
</div>