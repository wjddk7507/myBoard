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
<!-- jQuery 2.1.4 -->
<script	src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>

</head>
<style>
#wrap{
    height:150px;
    width:100%;
	background-color:white;
}
#head {
    height:65px;
    width:100%;
    position:fixed;
    z-index:999;
    top:0px;
    left:0px;
	padding:0;
    background-color:white;
    border-bottom:1px solid #F2F2F2;
}
#left_menu {
	display:flex;
	flex-flow:row nowrap;/*같은 라인에 정렬*/
	/*justify-content: space-between; margin 값 동일하게*/
}
#sidebar {
	width:250px;
	font-size:12px;
	position:fixed;
	float:left;
	top:68px;
	left:0;
	bottom:0;
	padding:0;
	height:100%;
	cursor:default;
	overflow-y:auto;
	z-index:100;
    background-color:white;
    /*border-right : 1px solid #F2F2F2;*/
	-webkit-transform: translate3d(-300px,0,0);
	-moz-transform: translate3d(-300px,0,0);
	transform: translate3d(-300px,0,0);
	-webkit-transition: all 0.2s;
	-moz-transition: all 0.2s;
	-ms-transition: all 0.2s;
	-o-transition: all 0.2s;
	transition: all 0.2s;
}

html.open #sidebar { 
	overflow-y: auto;
	-webkit-transform: translate3d(0,0,0);
	-moz-transform: translate3d(0,0,0);
	transform: translate3d(0,0,0);
	-webkit-transition: all 0.2s;
	-moz-transition: all 0.2s;
	-ms-transition: all 0.2s;
	-o-transition: all 0.2s;
	transition: all 0.2s;
}
.container{
	margin:auto;
}
/*추천 콘텐츠*/
#tv-wrapper{
	background-color:#F2F2F2; 
	text-align:center; 
	vertical-align:middle; 
	width:100%; 
	height:300px;
}
#tv{
	display:inline-block; 
	width:340px; 
	height:210px;
	margin: 45px 20px auto 20px;
}
#profile-img{
	width:30px;
	height:30px;
	border-radius:15px; /*반지금 25픽셀의 원이 만들어짐*/
}
#tv_contents{
	width:340px; 
	height:210px;
	position:absolute; 
	left:0px; 
	top:0px; 
	opacity:0;
}
.tv-img{
	width:340px; 
	height:210px;
	
}
 /*인기 게시판, 새로 생긴 게시판*/
 #board-main{
	width:100%;
	height:250px;
	padding:20px;
 }	
 #board-left{
 	float:left;
 	width:50%;
	max-width:400px;
 }
#board-right{
 	float:right;
 	width:50%;
	max-width:400px;
 }
</style>
<body>
<div id="wrap">
	<div id="head" class="wrapper">
		<div id="left_menu">
			<button class="btn btn-link" type="button" id="menuBtn" aria-label="Left Align">
				<img src="${pageContext.request.contextPath}/resources/menu.png">
			</button> 
			<button type="button" class="btn btn-link">
				<a href="${pageContext.request.contextPath}" style="color:#dda0dd">MyBoard</a>
			</button>
			<button type="button" class="btn btn-link">
				<a class="item" href="${pageContext.request.contextPath}/board/list" style="color:black">Board List</a> 
			</button>
			
			<c:if test="${member==null}">
				<button type="button" class="btn btn-link">
					<a class="ui item" href="${pageContext.request.contextPath}/member/login" style="color:black">Login</a>
				</button>
				<button type="button" class="btn btn-link">
					<a class="ui item" href="${pageContext.request.contextPath}/member/join" style="color:black">Join</a>
				</button>
			</c:if>
			<c:if test="${member!=null}">
				<button type="button" class="btn btn-link">
					<a class="ui item" href="${pageContext.request.contextPath}/member/logout" style="color:black">Logout</a>
				</button>
			</c:if>
			
		
		</div>
		   
	</div>
</div>	

<div class="sidebar" id="sidebar">
	<div class="list-group">
		<a href="${pageContext.request.contextPath}" class="list-group-item list-group-item-action">HOME</a>
		<a href="${pageContext.request.contextPath}/board/toplist" class="list-group-item list-group-item-action">Top30</a>
		
		<c:if test="${member==null}">
			<div class="list-group-item"><a href="${pageContext.request.contextPath}/member/login" >로그인</a>하시면 이용하실 수 있습니다</div>
		</c:if>
		<c:if test="${member!=null}">
			<div class="list-group-item">${member.nickname}님 환영합니다</div>			
			<a href="${pageContext.request.contextPath}/board/register" class="list-group-item list-group-item-action">Board 만들기</a>		
			<a href="${pageContext.request.contextPath}/board/bookmark" class="list-group-item list-group-item-action">북마크한 보드 보기</a>	
		</c:if>	
		
		
		<a href="${pageContext.request.contextPath}/member/sendmail?id=wjddk7507@naver.com" class="list-group-item list-group-item-action">
			&nbsp<br/>문의 메일 보내기<br/>wjddk7507@naver.com<br/>&nbsp
		</a>
	</div>
</div>
	
 <script>
 $('#menuBtn').click(function(){
	 $("html").toggleClass("open");
 })
 
</script>
</body>
	