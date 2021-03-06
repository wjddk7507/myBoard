<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
	<%@include file="../include/header.jsp"%>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="login-box well">
					<form accept-charset="UTF-8" role="form" method="post" action="login">
						<legend>Login</legend>
						<div style='color: red'>${msg}</div>
						<div class="form-group">
							<label for="username-email">이메일</label> 
							<input type="email" name="id" id="id" required="required" placeholder="Enter email" class="form-control" />
						</div>
						<div class="form-group">
							<label for="password">비밀번호</label> 
							<input type="password" name="pw" id="pw" placeholder="password" class="form-control" />
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-primary btn-login-submit btn-block m-t-md" value="로그인" />
						</div>
						<div class="form-group">
							<a href="join" class="btn btn-warning btn-block m-t-md">회원가입</a>
						</div>

						<div class="form-group">
							<a href="../" class="btn btn-success btn-block m-t-md">메인으로</a>
						</div>
					</form>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>

</body>
</html>