<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL의 core 기능을 사용하기 위하 설정 : if, forEach, set 사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Board</title>

<!-- 현재 기기의 너비에 맞추어서 출력을 하고 기본 크기는 1배 최대 크기도 1배 확대축소 못하게 하는 설정
모바일 웹 애플리케이션에서 주로 이용 -->
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>

<!-- 부트스트랩 스타일시트 파일 링크 설정 
contextPath는 절대 경로를 만들기 위해서 추가 -->
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- IE9 이전 버전에서 HTML5의 semantic 태그를 사용하기 위한 설정 -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.comrespond/1.4.2respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/semanticUI/semantic.css">
<!-- jQuery 2.1.4 -->
<script	src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/semanticUI/semantic.js"></script>

</head>

<body>

	<div class="wrapper" style="margin-left:30px;margin-top:10px">
		<header>
			<a href="${pageContext.request.contextPath}" style="color:#EECCEE"><h1>MyBoard</h1></a>
		</header>
	</div>
	<div class="ui top attached secondary menu">
		<a class="item" id="menuBtn">Menu</a> 
		<a class="item" id="menuBtn" href="${pageContext.request.contextPath}/board/list">Board List</a> 
		<a class="item" id="menuBtn" href="${pageContext.request.contextPath}/board/register">Board 만들기</a> 
		<div class="right menu">
		    <div class="ui action input">
		      <input type="text" placeholder="Search...">
		      <div class="ui button">Go</div>
		    </div>
		    <c:if test="${member==null}">
				<a class="ui item" href="${pageContext.request.contextPath}/member/login">Login</a>
				<a class="ui item" href="${pageContext.request.contextPath}/member/join">Join</a>
			</c:if>
				
			<c:if test="${member!=null}">
				<a class="ui item" href="${pageContext.request.contextPath}/member/logout">Logout</a>
			</c:if>
			
		  </div>
	</div>
	
	<div id="app">
		<div class="ui left vertical labeled sidebar menu">			
				<a class="item">&nbsp&nbsp&nbsp&nbsp&nbsp홈</a> 
				<a class="item">&nbsp&nbsp&nbsp&nbsp&nbsp인기</a> 
				<a class="item">&nbsp&nbsp&nbsp&nbsp&nbsp구독</a>
				 
				<div class="item" style="text-align:center">	
					<c:if test="${member==null}">
						<a href="${pageContext.request.contextPath}/member/login">로그인</a>
						하셔서 <br/> 참여중인 게시판을 <br/>확인하세요!
					</c:if>	
					<c:if test="${member!=null}">
						${member.nickname}님 환영합니다!
					</c:if>	
				</div>
				
			<c:if test="${member!=null}">
				<div class="item">
			    	참여중인 게시판
				    <div class="menu">
				      <a class="active item">Search</a>
				      <a class="purple item">Add</a>
				      <a class="item">Remove</a>
				    </div>
				 </div>		
				 <div class="item">
			    	최근 본 게시판
				    <div class="menu">
				      <a class="active item">Search</a>
				      <a class="purple item">Add</a>
				      <a class="item">Remove</a>
				    </div>
				 </div>		
				 <div class="item">
			    	북마크한  게시판
				    <div class="menu">
				      <a class="active item">Search</a>
				      <a class="purple item">Add</a>
				      <a class="item">Remove</a>
				    </div>
				 </div>		
			 </c:if>	
		</div>
		<div class="pusher">
			<%@ include file = "content.jsp"%>
      	</div>
    </div>
 
 <script>
		function toggleSidebar() {
			$('#app .ui.sidebar').sidebar({
				context : $('#app'),
				closable:false,
				dimPage:false
			})
	        .sidebar('setting', 'transition', 'push')
	        .sidebar('toggle');
			
		}
		$('#menuBtn').click(function() {
			toggleSidebar();
		})
		
</script>
</body>
	