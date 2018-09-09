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
	border:1px dashed black;
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
    border-bottom:1px solid black;
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
	top:151px;
	left:0;
	bottom:0;
	padding:0;
	height:100%;
	cursor:default;
	overflow-y:auto;
	z-index:100;
    background-color:white;
	border:1px dashed black;
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
	margin-left:100px;
}
#tv-wrapper{
		background-color:#F2F2F2; 
		text-align:center; 
		vertical-align:middle; 
		width:100%; 
		height:300px
}
#tv{
	display:inline-block; 
	width:400px; 
	height:230px;
	border:1px solid black;
	margin: 35px 20px auto 20px;
}
</style>
<body>
<div id="wrap">
	<div id="head" class="wrapper">
		<div id="left_menu" style=" border:1px dashed black">
			<button class="navbar-toggler" type="button" id="menuBtn">메뉴</button> 
			<a href="${pageContext.request.contextPath}" style="color:#dda0dd">MyBoard</a>
			<a class="item" href="${pageContext.request.contextPath}/board/list">Board List</a> 
			<div class="input-group input-group-sm mb-3" style="width:500px">
				<div class="input-group-prepend">
					<button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</button>
				    <div class="dropdown-menu">
				      <a class="dropdown-item" href="#">Action</a>
				      <a class="dropdown-item" href="#">Another action</a>
				      <a class="dropdown-item" href="#">Something else here</a>
				    </div>
				</div>
				<input type="text" class="form-control" placeholder="Search..." aria-describedby="button-addon2">
				<button class="btn btn-outline-secondary" type="button" id="button-addon1">Button</button>				
				
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
</div>	

<div class="sidebar" id="sidebar">
	<a class="item"href="${pageContext.request.contextPath}/board/register">Board 만들기</a> 
	
	<br/>
	<a href="${pageContext.request.contextPath}/member/sendmail?id=wjddk7507@naver.com">wjddk7507@naver.com</a>	
</div>
	
 <script>
 $('#menuBtn').click(function(){
	 $("html").toggleClass("open");
 })
</script>
</body>
	