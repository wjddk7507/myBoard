<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/semanticUI/semantic.css">
<script src="${pageContext.request.contextPath}/resources/semanticUI/semantic.js"></script>
<style>
</style>
</head>
<body>
	<div class="ui top attached demo menu">
		<a class="item" id="menuBtn">Menu</a> 
		<a class="item" href="#">목록보기</a>
		<a class="item" href="#">게시물 쓰기</a> 
		<a class="item" href="#">회원가입</a>
	</div>
	<div id="app">
		<div class="ui left vertical inverted labeled sidebar menu">
			<a class="item"> Home </a> 
			<a class="item"> Topics </a> 
			<a class="item"> Friends </a> 
			<a class="item"> History </a> 
			<a class="item"> Messages </a>
		</div>
		<div class="pusher">
        Your site's actual content
      </div>
    </div>
 
 <script>
		function toggleSidebar() {
			$('#app .ui.sidebar').sidebar({
				context : $('#app')
			})
	        .sidebar('setting', 'transition', 'push')
	        .sidebar('toggle');
		}
		$('#menuBtn').click(function() {
			toggleSidebar();
		})
		
	</script>
</body>
